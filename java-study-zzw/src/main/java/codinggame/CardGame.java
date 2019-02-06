package codinggame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class CardGame {


    public static void main(String[] args) {
        int playersCount = 4;
        int cardsCount = 52;
        Game game = new Game(playersCount, cardsCount);
        game.start();

        System.out.println(game.deck.getCardsCount()); // 52
        System.out.println(game.getPlayersCount()); // 4
        System.out.println(game.players.get(0).getCardsCount()); // 13
    }
}


enum CardColor {
    Spade, Diamond, Club, Heart
}

enum CardValue {
    Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace
}

class GameException extends RuntimeException {
}

class Card {
    public final CardColor color;
    public final CardValue value;

    public Card(CardColor cardColor, CardValue cardValue) {
        color = cardColor;
        value = cardValue;
    }
}

class Deck {
    public ArrayList<Card> cards;

    public int getCardsCount() {
        return cards == null ? 0 : cards.size();
    }

    public Deck(int cardsCount) {
        if (cardsCount % 4 != 0)
            throw new GameException();
        cards = new ArrayList<>(cardsCount);
        addCards(cardsCount);
    }

    private void addCards(int cardsToAdd) {
        int cardsAdded = 0;
        while (cardsAdded < cardsToAdd)
            for (CardColor cardColor : CardColor.values())
                for (CardValue cardValue : CardValue.values()) {
                    if (cardsAdded >= cardsToAdd)
                        break;
                    cards.add(new Card(cardColor, cardValue));
                    ++cardsAdded;
                }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}

class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        int cmp = o1.color.compareTo(o2.color);
        if (cmp != 0) {
            return cmp;
        }
        return o1.value.compareTo(o2.value);
    }
}

class Player {
    private String _name;

    // TO DO : uncomment and choose your Collection type
    public TreeSet<Card> cards;

    public int getCardsCount() {
        return cards == null ? 0 : cards.size();
    }

    public Player(String name) {
        _name = name;
        cards = new TreeSet<Card>(new CardComparator());
    }

    public void addCard(Card card) {

        if (cards.contains(card)) {
            throw new GameException();
        }
        cards.add(card);

    }
}

class Game {
    private int _cardsCount;
    private int _playersCount;
    public Deck deck;
    public List<Player> players;

    public int getPlayersCount() {
        return players == null ? 0 : players.size();
    }

    public Game(int playersCount, int cardsCount) {
        _playersCount = playersCount;
        _cardsCount = cardsCount;
        players = newListPlayer(playersCount);
        deck = new Deck(cardsCount);
    }

    public void distributeCardsEvenlyToPlayers() {
        // TO DO

        int cardsPerPlayer = deck.cards.size() / players.size();
        Iterator<Card> iter = deck.cards.iterator();
        while (iter.hasNext()) {
            Card card = iter.next();
            for (Player player : players) {
                if (player.cards.size() < cardsPerPlayer) {
                    try {
                        player.addCard(card);
                    } catch (GameException e) {
                        // skip
                    }
                }
            }

        }
    }

    private List<Player> newListPlayer(int playersCount) {
        List<Player> players = new ArrayList<>(playersCount);

        for (int i = 0; i < playersCount; ++i) {
            players.add(new Player("Player " + i));
        }
        return players;
    }

    public void start() {
        deck.shuffle();
        distributeCardsEvenlyToPlayers();
    }
}

