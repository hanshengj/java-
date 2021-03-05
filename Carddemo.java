import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Carddemo {

    public static void main(String[] args) {
        DeckCard as = new DeckCard();
        List<Card> listcards = as.buyCard();
        as.washCard(listcards);
        System.out.println(listcards);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入玩牌的人数");
        int people = sc.nextInt();
        List<List<Card>> ass = as.sendCard(listcards, people);
        for (int i = 0; i < people; i++) {
            System.out.println(ass.get(i));
        }
    }
}

//纸牌
class Card {
    public String suit;
    public int rank;

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "[" + suit + "," + rank + "]";
    }
}

//扑克牌
class DeckCard {
    public static final String[] suits = {"♥", "♠", "♦", "♣"};

    //获得新的扑克牌
    public List<Card> buyCard() {
        List<Card> cardList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                String suit1 = suits[i];
                int rank1 = j;
                Card card = new Card(suit1, rank1);
                cardList.add(card);
            }
        }
        return cardList;
    }

    //洗牌
    public void washCard(List<Card> listcard) {
        for (int i = listcard.size() - 1; i > 0; i--) {
            Random random = new Random();
            int j = random.nextInt(i);
            swap(listcard, i, j);
        }
    }


    public void swap(List<Card> cardList, int i, int j) {
        Card temp = cardList.get(i);
        cardList.set(i, cardList.get(j));
        cardList.set(j, temp);
    }

    //发牌
    public List<List<Card>> sendCard(List<Card> listCard, int people) {
        List<List<Card>> peoples = new ArrayList<>();
        for (int i = 0; i < people; i++) {
            peoples.add(new ArrayList<>());

        }
        while (!listCard.isEmpty()) {
            for (int i = 0; i < people; i++) {
                if (listCard.isEmpty()) {
                    break;
                }
                Card card = listCard.remove(0);
                peoples.get(i).add(card);
            }

        }
        return peoples;
    }
}
