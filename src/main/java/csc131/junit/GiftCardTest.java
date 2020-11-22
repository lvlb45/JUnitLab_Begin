package csc131.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GiftCardTest
{
	@Test
	public void getIssuingStore()
	{
		double balance;
		GiftCard card;
		int issuingStore;

		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
	}
	
	@Test
	public void getBalance()
	{
		double balance;
		GiftCard card;
		int issuingStore;

		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("getBalance()", balance, card.getBalance(), 0.001d);
	}
	
	@Test
	public void deduct()
	{
		double balance;
		int issuingStore;
		GiftCard card1;
		GiftCard card2;

		issuingStore = 1337;
		balance = 100.00;
		card1 = new GiftCard(issuingStore, balance);
		card2 = new GiftCard(issuingStore, balance);
		assertEquals("deduct()", card1.deduct(1.0d), card2.deduct(1.0d));
		assertEquals("deduct()", card1.deduct(-1.0d), card2.deduct(-1.0d));
		assertEquals("deduct()", card1.deduct(200.0d), card2.deduct(200.0d));
	}
	
	@Test
	public void constructor_NegativeBalance()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
	}
	
	@Test
	public void constructor_IncorrectID_Low()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-100,100.00d);});
	}
	
	@Test
	public void constructor_IncorrectID_High()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000,100.00d);});
	}
}
