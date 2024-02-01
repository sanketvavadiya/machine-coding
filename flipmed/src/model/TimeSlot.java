package src.model;

public class TimeSlot {
    public int start;
    public int end;
    public boolean isBookable;
    public TimeSlot(int start, int end) {
        this.start = start;
        this.end = end;
        this.isBookable = true;
    }

    @Override
    public boolean equals(Object object) {
        if(object == null)
            return false;
        TimeSlot other = (TimeSlot) object;
        return this.start == other.start && this.end == other.end;
    }

    public boolean overlaps(TimeSlot slot) {
        return Math.abs(this.start - slot.start) < 30;
    }
}
