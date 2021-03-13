
public class LightCruiser extends Ship {
	public LightCruiser() {
		setLength(5);
		setHit(new boolean[getLength()]);
	}
	
	@Override
	public String getShipType() {
		return "lightcruiser";
	}
}
