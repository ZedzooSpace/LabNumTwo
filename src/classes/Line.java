package classes;

public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() { return start; }
    public void setStart(Point start) { this.start = start; }

    public Point getEnd() { return end; }
    public void setEnd(Point end) { this.end = end; }
    public double getLength() {
        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2));
    }
    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}