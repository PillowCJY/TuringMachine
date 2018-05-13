/*159331 - Assignment 2 Semester 1
 * Junyi Chen - 16192554
 */

public class Instruction {

	/*Variables*/
	private String state;
	private String symbol;
	private String newState;
	private String newSymbol;
	private int movement;
	
	/*Constructor*/
	public Instruction(String oldState, String oldSymbol, String nState, String nSymbol, int move) {
		
		state = oldState;
		symbol = oldSymbol;
		newState = nState;
		newSymbol = nSymbol;
		movement = move;
		
	}
	/*Return true if state and symbo match the instruction*/
	public boolean checkStateAndSymbol(String myState, Character mySymbol){
		return (myState.equals(state)&& mySymbol.equals(symbol));
	}
	
	/*get the new state*/
	public String getNewState(){
		return newState;		
	}
	
	/*get the new symbol*/
	public String getNewSymbol(){
		return newSymbol;
	}
	
	/*get the next move*/
	public int getMove(){
		return movement;
	}
	
	public void printInsturction(){
		System.out.println(state + " " + symbol + "  ->  " + newState + " " + newSymbol + " " + movement);
	}
}
