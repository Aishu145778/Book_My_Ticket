public class Train {
    private String trainNam;
    private String trainId;
    private String source;
    private String destination;
    private int totalSeats;
    private int availableSeats;

    public Train(String trainNam, String trainId, String source, String destination, int totalSeats) {
        this.trainNam = trainNam;
        this.trainId = trainId;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public String getTrainNam() {
        return trainNam;
    }

    public void setTrainNam(String trainNam) {
        this.trainNam = trainNam;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTotalSeats(int seatCount) {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats(int seatCount) {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }


    public Boolean seat(int count)
    {
        if(count<availableSeats)
        {
            availableSeats-=count;
            return true;
        }
        return false;
    }

    public int cancel(int count)
    {
        return availableSeats+=count;
    }

    @Override
    public String toString() {
        return "Train:"+trainNam+" || TrainId:"+trainId+" || Source:"+source+" || Destination: "+destination+
                " || AvailableSeat: "+availableSeats;
    }
}
