public enum DayOfWeek {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday;

    public boolean isDayOf(){
     if (this.name() == "Saturday" || this.name() == "Sunday")
         return true;
     return false;
    }
}
