package quest;

import java.util.Timer;
import java.util.TimerTask;

public class Transactions {

    public static void withdraw(Bank account, int value, TransactionListener event) {
        //Simulation einer Zeitverzögerung: Abheben eines Betrages vom Bankkonto
        int time = (int) (Math.random() * ((1000 - 500) + 1)) + 500;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                account.setTotal(account.getTotal() - value);
                //Erst wenn die Transaktion durchgeführt wurde, läuft das Programm weiter
                event.onComplete(account);
            }
        }, time);
    }
}
