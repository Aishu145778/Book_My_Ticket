import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookingService {
    List<Train> trainList=new ArrayList<>();
    List<Ticket> ticketList=new ArrayList<>();

    public BookingService()
    {
        trainList.add(new Train("Intercity","IB2","Indore","Bhopal",100));
        trainList.add(new Train("bhopalexpress","BJ2","Bhopal","Jabalpur",10));
        trainList.add(new Train("jabalpurexpress","JI2","Jabalpur","Indore",98));
        trainList.add(new Train("BhopalNagpurExpress","BN2","Bhopal","Nagpur",54));
        trainList.add(new Train("SingrauliExpress","SI2","Singrauli","Indore",100));
        trainList.add(new Train("NightExpress","BJ3","Bhopal","Jabalpur",10));
        trainList.add(new Train("OverNightExpress","JI3","Jabalpur","Indore",98));
        trainList.add(new Train("NagpurBhopalExpress","NB3","Nagpur","Bhopal",54));
    }

    public List<Train> SearchTrain(String Source,String Destination)  /// apply date also
    {
        List<Train> res=new ArrayList<>();
        for(Train train:trainList)
        {
            if(train.getSource().equalsIgnoreCase(Source) && train.getDestination().equalsIgnoreCase(Destination))
            {
                res.add(train);
            }
        }
        return res;
    }

    Ticket BookTicket(User user, String TrainId, int SeatCount)
    {
        for(Train train:trainList)
        {
            if(train.getTrainId().equals(TrainId))
            {
                if(train.seat(SeatCount))
                {
                    Ticket ticket=new Ticket(user,train,SeatCount);
                    ticketList.add(ticket);
                    return ticket;
                }
                else{
                    System.out.println("Enough seat are not available");
                    return null;
                }
            }
        }
        System.out.println("Train ID not found");
        return null;
    }


    public List<Ticket> GetTicketByUser(User user)
    {
        List<Ticket> res=new ArrayList<>();
        for(Ticket ticket:ticketList)
        {
            if(ticket.getUser().getUserName().equalsIgnoreCase(user.getUserName()))
            {
                res.add(ticket);
            }
        }
        return res;
    }

    public void CancelTicket(int ticketId, User user)
    {
        Iterator<Ticket> iterator=ticketList.listIterator();
        while(iterator.hasNext()) {
            Ticket ticket = iterator.next();
            if (ticket.getTicketId() == ticketId &&
                    ticket.getUser().getUserId().equalsIgnoreCase(user.getUserId())) {
                Train train = ticket.getTrain();
                train.cancel(ticket.getSeatBooked());
                iterator.remove();
                System.out.println("Ticket " + ticketId + " Cancel Successfully");
                return;
            } else {
                System.out.println("TicketId not found or does not belongs to current user");
            }
        }

    }

    public void TrainList(){
        System.out.println("List of Train");
        for(Train train:trainList)
        {
            System.out.println(train);
        }
    }
}
