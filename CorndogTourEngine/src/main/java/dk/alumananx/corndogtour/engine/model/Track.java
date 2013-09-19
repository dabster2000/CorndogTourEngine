package dk.alumananx.corndogtour.engine.model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import dk.alumananx.corndogtour.engine.enums.Event;
import dk.alumananx.corndogtour.engine.fysics.PhysicsEngine;
import dk.alumananx.corndogtour.engine.utils.TextGenerator;

public class Track {

	int[] trackSegments =	{ 5, 12, 20, 25, 32, 40, 45, 50};
	int[] trackHeight =   	{ 0,  0, 10, 20, 30, 30, 25, 30};
	int[] trackDifficulty =	{ 0,  0,  2,  2,  2,  1,  2,  1};
	
	TextGenerator tg = new TextGenerator();
	private List<String> textOutput;
	
	public static void main(String[] args) throws IOException {
		new Track().gameloop();
	}
	
	public void gameloop() throws IOException {
		ArrayList<Group> groups = new ArrayList<>();
		
		Group peleton = new Group();
		
		groups.add(peleton);
		
		int bikerNumber = 1;
		Biker stamBiker = new Biker(Names.randomFirstname()+" "+Names.randomLastname(), 1, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10);
		peleton.bikers.add(stamBiker);
		peleton.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), 2, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		Biker mystBiker = new Biker(Names.randomFirstname()+" "+Names.randomLastname(), 3, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10);
		peleton.bikers.add(mystBiker);
		peleton.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), 4, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		peleton.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), 5, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		peleton.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), 6, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		peleton.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), 7, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		peleton.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), 8, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		peleton.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), 9, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		Biker speedBiker = new Biker(Names.randomFirstname()+" "+Names.randomLastname(), 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10);
		peleton.bikers.add(speedBiker);
		
		ArrayList<TrackSegment> trackSegmentList = new ArrayList<>();
		TrackSegment ts1 = new TrackSegment(6.4, 385, 385, 20, 0, 26);
		TrackSegment ts2 = new TrackSegment(6.6, 796, 385, 20, 0, 26);
		TrackSegment ts3 = new TrackSegment(29.6, 796, 796, 20, 0, 26);
		TrackSegment ts4 = new TrackSegment(2.4, 990, 796, 20, 0, 26);
		TrackSegment ts5 = new TrackSegment(44.9, 990, 990, 20, 0, 26);
		TrackSegment ts6 = new TrackSegment(5.1, 1371, 1030, 20, 0, 26);
		TrackSegment ts7 = new TrackSegment(15.2, 1371, 1371, 20, 0, 26);
		TrackSegment ts8 = new TrackSegment(12.3, 1765, 726, 20, 0, 26);
		TrackSegment ts9 = new TrackSegment(6, 1765, 1765, 20, 0, 26);
		TrackSegment ts10 = new TrackSegment(27.2, 726, 1999, 20, 0, 26);
		TrackSegment ts11 = new TrackSegment(13.8, 1850, 726, 20, 0, 26);
		//TrackSegment ts = new TrackSegment(12.3, 1765, 726, 20, 0, 26);
		trackSegmentList.add(ts1);
		trackSegmentList.add(ts2);
		trackSegmentList.add(ts3);
		trackSegmentList.add(ts4);
		trackSegmentList.add(ts5);
		trackSegmentList.add(ts6);
		trackSegmentList.add(ts7);
		trackSegmentList.add(ts8);
		trackSegmentList.add(ts9);
		trackSegmentList.add(ts10);
		trackSegmentList.add(ts11);
		TrackSegment currentTrackSegment = ts1;
		
		peleton.speed = calculateAvgLevelTop(peleton, 8);
		System.out.println("Peleton speed: " + peleton.speed);

		Date date = new Date();
		
		Bike bike = new Bike(6.1, 4, 1);
		
		boolean endOfRace = false;
		double time = 0;
		
		System.out.println(new SimpleDateFormat("hh:mm").format(date) +": "+tg.getStartText("200", new SimpleDateFormat("hh:mm").format(date)));
		
		textOutput = new ArrayList<>();
		int count = 0;
		while (!endOfRace) {
			//System.out.println("\n\n----------- NEW ROUND -----------");
			//System.out.println("Groups: "+groups.size());
			String earlyText = "";
			if((earlyText = tg.getEarlyStartText())!="")
				output(earlyText);
			
			time+=1;
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.MINUTE, 1);
			date = c.getTime();
			
			int groupNumber = 0;
			ArrayList<Group> newGroups = new ArrayList<>();
			for (Group currentGroup : groups) {
				// Get relevant TrackSegment
				double trackSegmentLength = 0.0;
				
				for (TrackSegment trackSegment : trackSegmentList) {
					trackSegmentLength += currentTrackSegment.getDistance();
					if(currentGroup.distance < trackSegmentLength) {
						if(currentTrackSegment != trackSegment) {
							if(trackSegment.getGrade() > 0.0) output(tg.getTrackChangeText(trackSegment));
							currentTrackSegment = trackSegment;
						}
						break;
					}
				}
				//System.out.println(currentTrackSegment.getGrade());
				
				// Move group
				double speedKmPerHour;
				if(currentGroup.fatigued) {
					speedKmPerHour = PhysicsEngine.getSpeedPerGradePerLevel(currentTrackSegment.getGrade(), currentGroup.speed / 4) / 3;
					//System.out.print("speed: "+currentGroup.speed);
					//System.out.println(", fatique: "+speedKmPerHour);
				}
				else speedKmPerHour = PhysicsEngine.getSpeedPerGradePerLevel(currentTrackSegment.getGrade(), currentGroup.speed);
				
				currentGroup.distance += (speedKmPerHour / 60);
				for (Biker biker : currentGroup.bikers) {
					double power = PhysicsEngine.getActualPowerUsed(biker, bike, currentTrackSegment, speedKmPerHour, currentGroup.bikers.size());
					if(biker == stamBiker && count++ == 1000) {
						System.out.println("Grade: "+currentTrackSegment.getGrade());
						System.out.println(stamBiker);
						System.out.print(biker.name+" - P:" + power);
						System.out.print(", DC:"+PhysicsEngine.calcCalories(1, power));
						System.out.print(", DSp:"+speedKmPerHour);
						System.out.print(", SSt:"+biker.sa.stamina);
						System.out.println(", DSt:"+biker.da.stamina);
						count = 0;
					}
					/**/
					biker.da.stamina -= PhysicsEngine.calcCalories(1, power);
				}
				
				// Calculate recovery
				for (Biker biker : currentGroup.bikers) {
					double bikerOptimalSpeed = PhysicsEngine.getSpeedPerGradePerLevel(currentTrackSegment.getGrade(), biker.sa.stamina);
					if(bikerOptimalSpeed > speedKmPerHour) {
						if(biker.da.fatigued) biker.da.stamina += biker.sa.getMaxStamina() * 0.002;
						else biker.da.stamina += biker.sa.getMaxStamina() * 0.001;
						
					}
				}
				
				// Handle fatiqued bikers
				ArrayList<Biker> removeGroup = new ArrayList<>();
				for (Biker biker : currentGroup.bikers) {
					if(!biker.da.fatigued && biker.da.stamina < 1000) {
						biker.da.fatigued = true;
						Group slowGroup = new Group();
						slowGroup.bikers.add(biker);
						slowGroup.name = biker.name;
						slowGroup.distance = currentGroup.distance;
						slowGroup.speed = calculateAvgStaminaTop(slowGroup, 1) * 0.5;
						slowGroup.fatigued = true;
						System.out.println(biker);
						
						removeGroup.add(biker);
						newGroups.add(slowGroup);
						output(tg.getStaminaText(biker));
					}
				}
				currentGroup.bikers.removeAll(removeGroup);
				
				// Calculate events
				calculateGroupEvents(newGroups, currentGroup);
				
				// Calculate new speed
				for (Biker biker : currentGroup.bikers) {
					int groupSize = currentGroup.bikers.size();
					if(groupSize > 8) groupSize = 8;
					currentGroup.speed = calculateAvgLevelTop(currentGroup, groupSize);
				}
			}
			groups.addAll(newGroups);
			
			//System.out.println("----------- END ROUND -----------"); 
			if(textOutput.size() > 0) System.out.println(new SimpleDateFormat("hh:mm").format(date) +": "+textOutput.remove(0));
			if(time==360) endOfRace = true;
			
			//System.in.read();
		}
		//System.out.println(mystBiker);
	}

	private void output(String s) {
		if(s == "") return;
		textOutput.add(s);
	}

	private double calculateAvgSpeedTop(Group group, int top) {
		Collections.sort(group.bikers, new Comparator<Biker>() {
            @Override
            public int compare(Biker e1, Biker e2) {
                Double id1 = ((Biker) e1).sa.speed;
                Double id2 = ((Biker) e2).sa.speed;
                return id2.compareTo(id1);
            }
        });
		
		double avgSpeed = 0;
		if(top == 0) top = group.bikers.size();
		for (int i = 0; i < top; i++) {
			avgSpeed += group.bikers.get(i).sa.speed;
			
		}
		avgSpeed = avgSpeed / group.bikers.size();
		return avgSpeed;
	}
	
	private double calculateAvgStaminaTop(Group group, int top) {
		Collections.sort(group.bikers, new Comparator<Biker>() {
            @Override
            public int compare(Biker e1, Biker e2) {
                Double id1 = ((Biker) e1).sa.stamina;
                Double id2 = ((Biker) e2).sa.stamina;
                return id2.compareTo(id1);
            }
        });
		
		double avgStamina = 0;
		if(top == 0) top = group.bikers.size();
		for (int i = 0; i < top; i++) {
			avgStamina += group.bikers.get(i).sa.stamina;
			
		}
		avgStamina = avgStamina / group.bikers.size();
		return avgStamina;
	}
	
	private double calculateAvgLevelTop(Group group, int top) {
		Collections.sort(group.bikers, new Comparator<Biker>() {
            @Override
            public int compare(Biker e1, Biker e2) {
                Integer id1 = ((Biker) e1).sa.level;
                Integer id2 = ((Biker) e2).sa.level;
                return id2.compareTo(id1);
            }
        });
		
		double avgLevel = 0;
		if(top == 0) top = group.bikers.size();
		for (int i = 0; i < top; i++) {
			avgLevel += group.bikers.get(i).sa.level;
			
		}
		avgLevel /= top;
		return avgLevel;
	}

	private void calculateGroupEvents(ArrayList<Group> newGroups,
			Group currentGroup) {
		Event event = Event.randomType();
		//System.out.println("   Event: " + event);
		switch (event) {
		case CRASH:
			Group crashedGroup = new Group();
			for (Biker biker : currentGroup.bikers) {
				if(Math.random()*10 > biker.sa.technique) {
					crashedGroup.bikers.add(biker);
					crashedGroup.distance = currentGroup.distance;
					crashedGroup.speed = 0;
				}
			}
			currentGroup.bikers.removeAll(crashedGroup.bikers);
			//System.out.println("   Crashed size: " + crashedGroup.bikers.size());
			if(crashedGroup.bikers.size() > 0) {
				crashedGroup.name = crashedGroup.bikers.get(0).name;
				newGroups.add(crashedGroup);
				output(tg.getCrashText(crashedGroup));
				output(tg.getGroupText(currentGroup.name));
			}
			break;
		
		default:
			break;
		}
	}
}
