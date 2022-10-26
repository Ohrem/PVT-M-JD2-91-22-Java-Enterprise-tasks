package ohremchuk.jdbc.task7.starter;
import ohremchuk.jdbc.task7.dao.ReceiverDao;
import ohremchuk.jdbc.task7.entity.Receiver;

public class DaoReceiverRunner {
    public static void main(String[] args) {
//       findAllReceiverTest();
//        saveReceiverTest();
//        deleteReceiverTest();
        updateTicketTest();
    }

    private static void findAllReceiverTest() {
        var receivers = ReceiverDao.getInstance().findAll();
        System.out.println(receivers);
    }


    private static void deleteReceiverTest() {
        var receiverDao = ReceiverDao.getInstance();
        var deleteResult = receiverDao.delete(5);
        System.out.println(deleteResult);
    }

    private static void saveReceiverTest() {
        var receiverDao = ReceiverDao.getInstance();
        Receiver receiver = new Receiver();
        receiver.setName("Sasha");
        receiver.setEmail("sashaImpressive@mail.ru");
        var savedReceiver = receiverDao.save(receiver);
        System.out.println(receiver);
    }
    private static void updateTicketTest() {
        var receiverDao = ReceiverDao.getInstance();
        var maybeExistReceiver = receiverDao.findById(3);
        System.out.println(maybeExistReceiver);

        maybeExistReceiver.ifPresent(receiver -> {
            receiver.setName("Anton");
            receiverDao.update(receiver);
        });
    }
}
