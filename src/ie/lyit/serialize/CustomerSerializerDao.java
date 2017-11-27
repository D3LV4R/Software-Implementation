package ie.lyit.serialize;

public interface CustomerSerializerDao {
	
	public void add();
	public void list();
	public void view(int number);
	public void editCustomer(int number);
	public void deleteCustomer(int number);
	public int getHeighestNumber();
	public void writeRecordsToFile();
	public void readRecordsFromFile();
}