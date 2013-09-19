package dk.alumananx.corndogtour.engine.services;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dk.alumananx.corndogtour.engine.dao.TeamDao;
import dk.alumananx.corndogtour.engine.model.Team;
import dk.alumananx.corndogtour.engine.services.messages.ServiceError;


@Controller
@RequestMapping("/user")
public class TeamController {
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TeamDao teamDao;
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/{username}", method = RequestMethod.GET)
	public ResponseEntity<Team> getUserToJson(@PathVariable String username) throws IOException {
		logger.info("getUserToJson: "+username);
		logger.info("getUserToJson: Found "+teamDao.getTeam(username));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		return new ResponseEntity<Team>(teamDao.getTeam(username), headers, HttpStatus.OK);
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> createUserFromJson(@RequestBody String json) {
		//System.out.println(json);
		logger.info("createUserFromJson: "+json);
		Team team = Team.fromJsonToUser(json);
		logger.info("createTeamFromJson: "+team);
	    try {
			teamDao.updateTeam(team);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			return new ResponseEntity<String>(team.toJson(), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			return new ResponseEntity<String>(new ServiceError(1, "User already exists").toJson(), headers, HttpStatus.CONFLICT);
		}
	}
	/*
	@Transactional
	@RequestMapping(value="/{username}/challenge/ranked", method = RequestMethod.POST)
	public @ResponseBody String createChallenge(@PathVariable String username) throws IOException {
		logger.info("createChallenge: "+username);
		User user = userDao.getUser(username);
		logger.debug("createChallenge: Found "+user);
		
		if(user.challenges.size() == 0) {
			RankedChallenge challenge = new RankedChallenge(user, (user.eloRating / 10) );
			
			userDao.persistRankedChallenge(challenge);
			
			user.challenges.add(challenge);
			user = userDao.mergeUser(user);
			
			logger.debug("createChallenge: Created "+challenge);
			
			return challenge.toJson();
		}
		
		logger.debug("createChallenge: Retrieved "+user.challenges.get(0));
		return user.challenges.get(0).toJson();
	}
	
	@Transactional
	@RequestMapping(value="/{username}/challenge/ranked/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteChallenge(@PathVariable String username, @PathVariable Long id) throws IOException {
		logger.info("deleteChallenge: "+id);
		userDao.deleteRankedChallenge(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		return new ResponseEntity<String>(headers, HttpStatus.OK);
	}
	
	@Transactional
	@RequestMapping(value="/{username}/challenge/ranked/all", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAllChallenges(@PathVariable String username) throws IOException {
		logger.info("deleteAllChallenges: "+username);
		
		userDao.deleteAllChallenges(username);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		return new ResponseEntity<String>(headers, HttpStatus.OK);
	}
	
	@Transactional
	@RequestMapping(value="/challenge/ranked/all", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAllChallenges() throws IOException {
		logger.info("deleteAllChallenges: ");
		userDao.deleteAllChallenges();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		return new ResponseEntity<String>(headers, HttpStatus.OK);
	}*/
}
