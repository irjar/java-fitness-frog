





Fitness frogs move like frogs except when they are sprinting.

Sprinting involves a fitness frog changing its colour to red, moving a random number
of stones (between 2 and 5 inclusive) in a rightward direction, one stone at a time,
jumping once and then changing its colour back to what it was before sprinting.

Fitness frogs keep track of the total distance they have sprinted.

Fitness frogs always start sprinting from their current position.

A ‘running track’ is composed of the black stones (numbered 1 to 11) and there is a
'wrap-around', the effect of which is such that if a fitness frog is currently positioned
on the last black stone (number 11) and sprints, it will move to the first black stone
(number 1) and continue sprinting from there.

A training session consists of two fitness frogs sprinting a number of times specified
by the user (between 1 and 5 inclusive). Both fitness frogs sprint the same number of
times.

At the start of a training session, the total distance each fitness frog has sprinted is
reset to 0.

At the end of a training session, the fittest fitness frog is the one that has sprinted
furthest and it announces this by turning yellow and croaking once. If the fitness frogs
have sprinted the same total distance, there is no fittest fitness frog.

This project explores orchestration, defensive programming and exception handling.


FitnessFrog ff1 = new FitnessFrog(); // creates a new fitness frog ff1
FitnessFrog ff2 = new FitnessFrog(); // creates a new fitness frog ff2

Coach c = new Coach(ff1, ff2); 		// creates a new coach for fitness frogs ff1 and ff2
c.train();				// executes the train() method 				
ff1.setPosition(0);			// sets position of the ff1 to stone 0
ff2.setPosition(12);			// sets position of the ff2 to stone 0
c.train();				// tests if the fitness frogs sprint along the running track


// Tests if the modified train() method and the helper method work correctly. 
// Nothing should happen when lines 6 and 10 are executed. When the line 14 
// is executed the fitness frogs should move along the running track.

FitnessFrog ff1 = new FitnessFrog(); // Line 1
FitnessFrog ff2 = new FitnessFrog(); // Line 2
Coach c = new Coach(ff1, ff2); // Line 3
ff1.setPosition(0); // Line 4
ff2.setPosition(12); // Line 5
c.train(); // Line 6
Coach c = new Coach(ff1, ff2); // Line 7
ff1.setPosition(1); // Line 8
ff2.setPosition(12); // Line 9
c.train(); // Line 10
Coach c = new Coach(ff1, ff2); // Line 11
ff1.setPosition(2); // Line 12
ff2.setPosition(10); // Line 13
c.train(); // Line 14