package dk.ernstlassen.corndog.fysics;

import dk.ernstlassen.corndog.model.Bike;
import dk.ernstlassen.corndog.model.Biker;
import dk.ernstlassen.corndog.model.TrackSegment;


public class PhysicsEngineTest {


	public void testCalcVelocity() {
		//fail("Not yet implemented"); // TODO
		Biker biker = new Biker("Hans", 0, 0, 0, 0, 64, 0);
		Bike bike = new Bike(6.1, 4, 1);
		//TrackSegment ts = new TrackSegment(20.5, 436, 163, 20, 0, 26);
		
		//double distance, double height, double previousHeight, double headwind, double position, double temperature
		TrackSegment ts = new TrackSegment(0.25, 60, 60, 0, 0, 26);
		
		double power = 20;
		double speed = PhysicsEngine.calcVelocity(biker, bike, ts, power);
		double time = PhysicsEngine.calcTime(biker, bike, ts, power);
		double calories = PhysicsEngine.calcCalories(time, power);
		
		
		System.out.println(speed);
		System.out.println(time);
		System.out.println(calories);
	}
	
	public void testCalcPower() {
		//fail("Not yet implemented"); // TODO
		Biker biker = new Biker("Hans", 0, 0, 0, 0, 64, 0);
		Bike bike = new Bike(6.1, 4, 1);
		//TrackSegment ts = new TrackSegment(20.5, 436, 163, 20, 0, 26);
		
		//double distance, double height, double previousHeight, double headwind, double position, double temperature
		// TrackSegment ts = new TrackSegment(3, 1999, 1765, 0, 0, 26); // Alpe d'Huez
		TrackSegment ts = new TrackSegment(3, 100, 100, 0, 0, 26); // Flat
		
		double speed = 45;
		double power = PhysicsEngine.calcPower(biker, bike, ts, speed);
		//double time = new FysicsEngine().calcTime(biker, bike, ts, speed);
		//double calories = new FysicsEngine().calcCalories(time, speed);
		
		
		System.out.println(power);
	}

	public static void main(String[] args) {
		int var = 3200;
		System.out.println(Math.log1p(0)*var+500);
		System.out.println(Math.log1p(2)*var+500);
		System.out.println(Math.log1p(10)*var+500);
		//new PhysicsEngineTest().testCalcVelocity();
		//System.out.println("-------------");
		//new PhysicsEngineTest().testCalcPower();
	}
	
	public void testCalcTime() {
		/*
		Racer racer = new Racer(65, 250);
		Bike bike = new Bike(9, 5, 0);
		Terrain terrain = new Terrain(100, 25, 0, 7.8);
		*/
		PhysicsEngine fysicsEngine = new PhysicsEngine();
		//System.out.println(fysicsEngine.calcVelocity(racer, bike, terrain, 410.0));
		//System.out.println(fysicsEngine.calcTime(racer, bike, terrain, 410.0, 7.8));
	}

}


/*
calcMode=units=0;tireValues=[0.005,0.004,0.012];
aeroValues=[0.388,0.445,0.42,0.3,0.233,0.2];

function makeDecimal2(a) {
	if(null != a && 0 != a)
		var b=Math.round(100*parseFloat(a)),a=100>b?0:
	
	parseInt(b/100),b=b%100,a=""+a+"."+(10<=b?"":"0")+b;
	return a
}

function makeDecimal0(a) {
	null != a && 0 != a && (a="" + Math.round(parseFloat(a)));
	return a
}

function valDecNumber(a) {
	if(0 == a.length) return !1;
	var b=!0, d=!0;
	
	for(i=0;i<a.length;i++) {
		var f=a.substring(i,i+1);
		if(d && "." == f) 
			d=!1;
		else if(b && "-" == f)
			b=!1;
		else if("0">f||"9"<f)return alert("I don't think you want to do that, Dave."),!1}return!0}function empty(a){return""==a||null==a?!0:!1}function newton(a,b,d,f,h){var g=20;for(i=1;10>i;i++){var e=g+b,e=g-(g*(a*e*e+d)-f*h)/(a*(3*g+b)*e+d);if(0.05>Math.abs(e-g))return e;g=e}return 0}function setMode(a){calcMode=a}
function changeUnits(a){with(a)units=unitsMenu.selectedIndex,0==units?(rweight.value=makeDecimal0(rweightv),bweight.value=makeDecimal0(bweightv),headwind.value=makeDecimal0(3.6*headwindv),distance.value=makeDecimal2(distancev),temperature.value=makeDecimal0(temperaturev),elevation.value=makeDecimal0(elevationv)):(rweight.value=makeDecimal0(2.205*rweightv),bweight.value=makeDecimal0(2.205*bweightv),headwind.value=makeDecimal0(2.2374*headwindv),distance.value=makeDecimal2(0.6215*distancev),temperature.value=
makeDecimal0(1.8*temperaturev+32),elevation.value=makeDecimal0(3.281*elevationv)),calcMode=0,update(a)}function updateDistance(a,b){with(a)1==b?(newTime=eval(time.value),distancev*=newTime/t):2==b?(newCal=eval(calories.value)*(units?4.188:1),distancev*=newCal/c):(newWeightloss=eval(weightloss.value)*(units?0.4536:1),distancev*=newWeightloss/wl),distance.value=makeDecimal2(distancev*(units?0.6214:1)),update(a)}
function update(a){with(a)rweightv=eval(rweight.value)*(units?0.4536:1),bweightv=eval(bweight.value)*(units?0.4536:1),theTire=tire.selectedIndex,rollingRes=tireValues[theTire],theAero=aero.selectedIndex,frontalArea=aeroValues[theAero],gradev=0.01*eval(grade.value),headwindv=eval(headwind.value)*(units?1.609:1)/3.6,distancev=eval(distance.value)*(units?1.609:1),temperaturev=(eval(temperature.value)-(units?32:0))*(units?0.5555:1),elevationv=eval(elevation.value)*(units?0.3048:1),transv=0.95,density=
(1.293-0.00426*temperaturev)*Math.exp(-elevationv/7E3),twt=9.8*(rweightv+bweightv),A2=0.5*frontalArea*density,tres=twt*(gradev+rollingRes),calcMode?(v=eval(velocity.value)/3.6*(units?1.609:1),tv=v+headwindv,powerv=(v*tres+v*tv*tv*A2)/transv,t=0<v?16.6667*distancev/v:0,power.value=makeDecimal0(powerv),dragSlider.setValue(powerv/500)):(powerv=eval(power.value),v=3.6*newton(A2,headwindv,tres,transv,powerv),t=0<v?60*distancev/v:0,velocity.value=makeDecimal2(v*(units?0.6214:1))),c=0.24*t*powerv,wl=c/32318,
time.value=makeDecimal2(t),calories.value=makeDecimal0(c*(units?0.2388:1)),weightloss.value=makeDecimal2(wl*(units?2.205:1))}function startDragSlider(){dragSlider=new Dragdealer("powerCtrl",{x:0.3,animationCallback:function(a){var b=document.getElementById("powerID"),d=document.getElementById("calcID");b.value=makeDecimal0(500*a);calcMode=0;update(d)}})};
*/