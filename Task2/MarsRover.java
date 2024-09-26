import java.util.*;

interface Command {
    void execute();
}

class Rover {
    private Position position;
    private Grid grid;
    private boolean obstacleDetected;

    public Rover(Position startPosition, Grid grid) {
        this.position = startPosition;
        this.grid = grid;
        this.obstacleDetected = false;
    }

    public void move() {
        Position nextPosition = position.nextPosition();
        if (!grid.hasObstacle(nextPosition)) {
            position = position.move();
            obstacleDetected = false;
        } 
        else {
            obstacleDetected = true;
            System.out.println("Obstacle detected at (" + nextPosition.getX() + ", " + nextPosition.getY() + "). Cannot move forward.");
        }
    }

    public void turnLeft() {
        position = position.turnLeft();
    }

    public void turnRight() {
        position = position.turnRight();
    }

    public void statusReport() {
        String obstacleMessage = obstacleDetected ? "Obstacle detected in the path." : "No obstacles detected.";
        System.out.println("Rover is at (" + position.getX() + ", " + position.getY() + ") facing " + position.getDirection() + ". " + obstacleMessage);
    }
}

class Position {
    private int x, y;
    private Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Position move() {
        return direction.move(this);
    }

    public Position turnLeft() {
        return new Position(x, y, direction.turnLeft());
    }

    public Position turnRight() {
        return new Position(x, y, direction.turnRight());
    }

    public Position nextPosition() {
        return direction.nextPosition(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }
}

enum Direction {
    NORTH {
        public Position move(Position position) {
            return new Position(position.getX(), position.getY() + 1, this);
        }

        public Direction turnLeft() {
            return WEST;
        }

        public Direction turnRight() {
            return EAST;
        }

        public Position nextPosition(Position position) {
            return new Position(position.getX(), position.getY() + 1, this);
        }
    },
    SOUTH {
        public Position move(Position position) {
            return new Position(position.getX(), position.getY() - 1, this);
        }

        public Direction turnLeft() {
            return EAST;
        }

        public Direction turnRight() {
            return WEST;
        }

        public Position nextPosition(Position position) {
            return new Position(position.getX(), position.getY() - 1, this);
        }
    },
    EAST {
        public Position move(Position position) {
            return new Position(position.getX() + 1, position.getY(), this);
        }

        public Direction turnLeft() {
            return NORTH;
        }

        public Direction turnRight() {
            return SOUTH;
        }

        public Position nextPosition(Position position) {
            return new Position(position.getX() + 1, position.getY(), this);
        }
    },
    WEST {
        public Position move(Position position) {
            return new Position(position.getX() - 1, position.getY(), this);
        }

        public Direction turnLeft() {
            return SOUTH;
        }

        public Direction turnRight() {
            return NORTH;
        }

        public Position nextPosition(Position position) {
            return new Position(position.getX() - 1, position.getY(), this);
        }
    };

    public abstract Position move(Position position);

    public abstract Direction turnLeft();

    public abstract Direction turnRight();

    public abstract Position nextPosition(Position position);
}

class Grid {
    private final int width;
    private final int height;
    private final List<Obstacle> obstacles;

    public Grid(int width, int height, List<Obstacle> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = obstacles;
    }

    public boolean hasObstacle(Position position) {
        return obstacles.stream().anyMatch(o -> o.isAt(position));
    }
}

class Obstacle {
    private final int x;
    private final int y;

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isAt(Position position) {
        return position.getX() == x && position.getY() == y;
    }
}

class MoveCommand implements Command {
    private final Rover rover;

    public MoveCommand(Rover rover) {
        this.rover = rover;
    }

    public void execute() {
        rover.move();
    }
}

class TurnLeftCommand implements Command {
    private final Rover rover;

    public TurnLeftCommand(Rover rover) {
        this.rover = rover;
    }

    public void execute() {
        rover.turnLeft();
    }
}

class TurnRightCommand implements Command {
    private final Rover rover;

    public TurnRightCommand(Rover rover) {
        this.rover = rover;
    }

    public void execute() {
        rover.turnRight();
    }
}

public class MarsRover {
    public static void main(String[] args) {
        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Obstacle(2, 2));
        obstacles.add(new Obstacle(3, 5));
        Grid grid = new Grid(10, 10, obstacles);

        Rover rover = new Rover(new Position(0, 0, Direction.NORTH), grid);

        Command[] commands = {
                new MoveCommand(rover),
                new MoveCommand(rover),
                new TurnRightCommand(rover),
                new MoveCommand(rover),
                new TurnLeftCommand(rover),
                new MoveCommand(rover)
        };

        for (Command command : commands) {
            command.execute();
        }

        rover.statusReport();
    }
}