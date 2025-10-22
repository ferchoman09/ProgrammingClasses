package GarageDoorChallenge;

/*
Situation
You have been tasked with reimplementing the logic for a garage door opener. Accidents with the present product line have resulted in numerous damaged cars.

Specification
We always start with a closed door. The remote control has exactly one button, with the following behaviour.

If the door is closed, a push starts opening the door, and vice-versa
It takes 5 seconds for the door to open or close completely
While the door is moving, one push pauses movement, another push resumes movement in the same direction
In order to make the door safer, it has been equiped with resistance-based obstacle detection. When the door detects an obstacle, it must immediately reverse the direction of movement.

Input
A string where each character represents one second, with the following possible values.

'.' No event
'P' Button has been pressed
'O' Obstacle has been detected (supersedes P)
As an example, '..P....' means that nothing happens for two seconds, then the button is pressed, then there were no further events.

Output
A string where each character represents one second and indicates the position of the door (0 if fully closed and 5 fully open). The door starts moving immediately, hence its position changes at the same second as the event.

Example
..P...O..... as input should yield
001234321000 as output

 */


public class GarageDoorChallenge {
    public static String garageDoor(String events) {
        StringBuilder result = new StringBuilder();
        int doorPosition = 0;
        int direction = 0; // 1 for opening, -1 for closing, 0 for stopped
        int lastDirection = 1; // Default to opening

        for (char event : events.toCharArray()) {
            if (event == 'O') {
                if (direction != 0) {
                    direction = -direction;
                    lastDirection = direction;
                }
            } else if (event == 'P') {
                if (direction == 0) {
                    if (doorPosition == 0) {
                        direction = 1;
                    } else if (doorPosition == 5) {
                        direction = -1;
                    } else {
                        direction = lastDirection;
                    }
                } else {
                    lastDirection = direction;
                    direction = 0;
                }
            }

            if (direction != 0) {
                doorPosition += direction;
                if (doorPosition == 0 || doorPosition == 5) {
                    direction = 0;
                }
            }
            result.append(doorPosition);
        }
        return result.toString();
    }
}
