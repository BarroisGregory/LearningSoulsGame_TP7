package lsg.buffs;

import java.util.Locale;

public abstract class BuffItem implements lsg.bags.Collectible{
	
	private String name ; 
	
	public BuffItem(String name) {
		this.name = name ;
	}
	
	public abstract float computeBuffValue() ;

	public int getWeight(){
		return 1;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return String.format(Locale.US, "[%s, %.2f]", getName(), computeBuffValue()) ;
	}
	
}
