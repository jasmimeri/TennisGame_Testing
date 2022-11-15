import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
    public void testTennisGame_Player1Wins() throws TennisGameException {
        //Arrange
        TennisGame game = new TennisGame();
        //Act
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        //Act
        String score = game.getScore();
        //Assert
        assertEquals("Player1 should have won", "player1 wins", score);
    }
	
	@Test
    public void testTennisGame_Player2Wins() throws TennisGameException {
        //Arrange
        TennisGame game = new TennisGame();
        //Act
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        //Act
        String score = game.getScore();
        //Assert
        assertEquals("Player2 should have won", "player2 wins", score);
    }
	
	@Test
    public void testTennisGame_Player1Wins_Over4() throws TennisGameException {
        //Arrange
        TennisGame game = new TennisGame();
        //Act
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        
        game.player1Scored();
        game.player1Scored();
        //Act
        String score = game.getScore();
        //Assert
        assertEquals("Player1 should have won", "player1 wins", score);
    }
	
	@Test
    public void testTennisGame_Player2Wins_Over4() throws TennisGameException {
        //Arrange
        TennisGame game = new TennisGame();
        //Act
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        
        game.player2Scored();
        game.player2Scored();
        //Act
        String score = game.getScore();
        //Assert
        assertEquals("Player2 should have won", "player2 wins", score);
    }
	
	@Test
	public void testTennisGame_EachPlayerWin1Point_Score_15() throws TennisGameException {
		//Arrange
	    TennisGame game = new TennisGame();
	    //Act
	    game.player1Scored();
	    game.player2Scored();
	    //Act
	    String score = game.getScore();
	    //Assert
	    assertEquals("Tie score incorrect", "15 - 15", score);
	}
	
	@Test
	public void testTennisGame_EachPlayerWin2Point_Score_30() throws TennisGameException {
		//Arrange
	    TennisGame game = new TennisGame();
	    //Act
	    game.player1Scored();
	    game.player2Scored();
	    game.player1Scored();
	    game.player2Scored();
	    //Act
	    String score = game.getScore();
	    //Assert
	    assertEquals("Tie score incorrect", "30 - 30", score);
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin3Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();

		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test
	public void testTennisGame_Score_love_15() throws TennisGameException {
		//Arrange
	    TennisGame game = new TennisGame();
	    //Act
	    game.player2Scored();
	    //Act
	    String score = game.getScore();
	    //Assert
	    assertEquals("Score should be love - 15", "love - 15", score);
	}
	
	@Test
	public void testTennisGame_Score_15_love() throws TennisGameException {
		//Arrange
	    TennisGame game = new TennisGame();
	    //Act
	    game.player1Scored();
	    //Act
	    String score = game.getScore();
	    //Assert
	    assertEquals("Score should be 15 - love", "15 - love", score);
	}
	
	@Test
	public void testTennisGame_Score_love_30() throws TennisGameException {
		//Arrange
	    TennisGame game = new TennisGame();
	    //Act
	    game.player2Scored();
	    game.player2Scored();
	    //Act
	    String score = game.getScore();
	    //Assert
	    assertEquals("Score should be love - 30", "love - 30", score);
	}
	
	@Test
	public void testTennisGame_Score_40_love() throws TennisGameException {
		//Arrange
	    TennisGame game = new TennisGame();
	    //Act
	    game.player1Scored();
	    game.player1Scored();
	    game.player1Scored();
	    //Act
	    String score = game.getScore();
	    //Assert
	    assertEquals("Score should be 40 - love", "40 - love", score);
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();

		// This statement should cause an exception
		game.player1Scored();			
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();

		// This statement should cause an exception
		game.player2Scored();			
	}
	
	@Test
    public void testTennisGame_Player1HasAdvantage() throws TennisGameException {
        //Arrange
        TennisGame game = new TennisGame();
        //Act
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();

        game.player1Scored();

        //Act
        String score = game.getScore();
        //Assert
        assertEquals("Player1 should have advantage", "player1 has advantage", score);
    }
	
	@Test
    public void testTennisGame_Player2HasAdvantage() throws TennisGameException {
        //Arrange
        TennisGame game = new TennisGame();
        //Act
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();

        game.player2Scored();

        //Act
        String score = game.getScore();
        //Assert
        assertEquals("Player2 should have advantage", "player2 has advantage", score);
    }
	
	@Test
    public void testTennisGame_Player1HasAdvantage_Over4() throws TennisGameException {
        //Arrange
        TennisGame game = new TennisGame();
        //Act
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();

        game.player1Scored();
        game.player2Scored();
        
        game.player1Scored();

        //Act
        String score = game.getScore();
        //Assert
        assertEquals("Player1 should have advantage", "player1 has advantage", score);
    }
	
	@Test
    public void testTennisGame_Player2HasAdvantage_Over4() throws TennisGameException {
        //Arrange
        TennisGame game = new TennisGame();
        //Act
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();

        game.player1Scored();
        game.player2Scored();
        
        game.player2Scored();

        //Act
        String score = game.getScore();
        //Assert
        assertEquals("Player2 should have advantage", "player2 has advantage", score);
    }
	
}
