public class Appointment {

    private Buyer buyer;
    private String appointmentDate; // in yyyy-mm-dd format, eg. 2021-08-10
    private String appointmentTime; // in 24hr format, eg. 20:30

    public Appointment(Buyer buyer, String appointmentDate, String appointmentTime) {
        this.buyer = buyer;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "buyer=" + buyer +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                '}';
    }
}