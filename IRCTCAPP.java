import java.util.List;
import java.util.Scanner;
import java.util.SplittableRandom;

public class IRCTCAPP {

    private final Scanner scanner=new Scanner(System.in);

    private final UserService userService=new UserService();

    private final BookingService BookingService=new BookingService();

    static void main(String[] args) {

        new IRCTCAPP().start();
    }

    public void start()
    {

        while(true)
        {
            System.out.println("-------Welcome to IRCTC APP--------");
            if(!userService.IsLogIn())
            {
                System.out.println("1. Register");
                System.out.println("2. LogIn");
                System.out.println("3. ExitApp");
                System.out.println("Enter your Choice");

                int Choice=scanner.nextInt();

                switch (Choice)
                {
                    case 1-> Register();
                    case 2-> LogIn();
                    case 3-> ExitApp();
                    default -> System.out.println("Invalid Choice");
                }

            }
            else {
                ShowUserMenu();
            }
        }
    }

    public void Register()
    {
        System.out.print("Enter the Name:");
        String username=scanner.next();
        System.out.print("Enter your Password:");
        String password=scanner.next();
        System.out.print("Enter your FullName:");
        String fullName=scanner.next();
        System.out.print("Contact info:");
        String contact=scanner.next();

        userService.RegisterUser(username,password,fullName,contact);
    }

    public void LogIn()
    {
        System.out.print("Enter your Name..");
        String username=scanner.next();
        System.out.print("Enter user password..");
        String password=scanner.next();
        userService.LogInUser(username,password);
    }

    public void ExitApp()
    {
        System.out.println("Thank You for Visiting...");
        System.exit(0);
    }

    private void ShowUserMenu()
    {
        while (userService.IsLogIn())
        {
            System.out.println("-------User Menu-------");
            System.out.println("1. Search Train");
            System.out.println("2. Book Ticket");
            System.out.println("3. View My Ticket");
            System.out.println("4. Cancel My Ticket");
            System.out.println("5. View all Train");
            System.out.println("6. LogOut");
            System.out.println("Enter your Choice");

            int Choice=scanner.nextInt();

            switch (Choice)
            {
                case 1-> searchTrain();
                case 2-> BookTicket();
                case 3-> ViewTicket();
                case 4-> CancelTicket();
                case 5-> BookingService.TrainList();
                case 6-> userService.LogOut();
                default -> System.out.println("Invalid Choice");

            }
        }
    }

    public void searchTrain()
    {
        System.out.print("Enter the Source:");
        String source=scanner.next();
        System.out.print("Enter the Destination:");
        String destination=scanner.next();

        List<Train> trains=BookingService.SearchTrain(source,destination);
        if(trains.isEmpty())
        {
            System.out.println("Train not Found");
            return;
        }
        System.out.println("Train Found");
        for(Train train:trains)
        {
            System.out.println(train);
        }

        System.out.println("Do You Want Book The Ticket (yes/no)");
        String choice=scanner.next();

        if(choice.equalsIgnoreCase("yes"))
        {
            System.out.print("Enter the TrainId:");
            String TrainId=scanner.next();
            System.out.print("Enter Number of Seat to Book:");
            int seats=scanner.nextInt();

            Ticket ticket=BookingService.BookTicket(userService.getCurrentUser(),TrainId,seats);
            if(ticket!=null)
            {
                System.out.println("Booking Successfull");
                System.out.println(ticket);
            }

        }
        else {
            System.out.println("Returning to User Menu....");
        }
    }

    public void BookTicket()
    {
        System.out.println("Enter the Source");
        String source=scanner.next();
        System.out.println("Enter the Destination");
        String destination=scanner.next();

        List<Train> trains=BookingService.SearchTrain(source,destination);
        if(trains.isEmpty())
        {
            System.out.println("No Trains are Available from "+source+" to "+destination);
            return;
        }
        System.out.println("Available Trains");
        for(Train train:trains)
        {
            System.out.println(train);
        }

        System.out.print("Enter the TrainId which you want to book:");
        String TrainId=scanner.next();
        System.out.println("Enter Number of Seat to Book:");
        int seats=scanner.nextInt();

        Ticket ticket=BookingService.BookTicket(userService.getCurrentUser(),TrainId,seats);
        if(ticket!=null)
        {
            System.out.println("Booking Successfully");
            System.out.println(ticket);
        }

    }

    private void ViewTicket(){

        List<Ticket> userTicket=BookingService.GetTicketByUser(userService.getCurrentUser());
        if(userTicket.isEmpty())
        {
            System.out.println("Ticket Not Found");
        }else{
            for(Ticket ticket:userTicket)
            {
                System.out.println(ticket);
            }
        }
    }

    private void CancelTicket()
    {
        System.out.print("Enter the TicketId:");
        int TicketId=scanner.nextInt();
        BookingService.CancelTicket(TicketId,userService.getCurrentUser());
    }


}
