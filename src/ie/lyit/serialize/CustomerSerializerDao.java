package ie.lyit.serialize;

import java.util.List;

import ie.lyit.serialize.CustomerSerializer.Memento;

public interface CustomerSerializerDao {
	
	public void add();
	public void list();
	public void view(int number);
	public void editCustomer(int number);
	public void deleteCustomer(int number);
	public int getHeighestNumber();
	public void writeRecordsToFile();
	public void readRecordsFromFile();
	
	public List<CustomerSerializer.Memento> GetUndoListFromSave();
	public Memento saveToMemento();
	public void restoreFromMemento(Memento memento);
}