package HashTable;

import interfaces.HashTableInterface;

public class HashTable implements HashTableInterface<String, String> {

	private HashTableEntry[] table;
	private int size;

	public HashTable() {
		this.table = new HashTableEntry[10];
		this.size = 0;
	}

	
	public void add(String key, String value) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % this.table.length;
		
		 if (this.size >= this.table.length * 0.5) {  
		        reHash();  
		    } 
		 

		System.out.println("KEY: " + key + " INDEX: " + index);

		HashTableEntry currentEntry = this.table[index];
		while (currentEntry != null) {
			index++;
			if (index >= this.table.length) {
				index = 0;
			}
			currentEntry = this.table[index];
		}
		this.table[index] = new HashTableEntry(key, value);
		this.size++;
	}
	
	public void reHash() {  
		HashTableEntry[] oldTable = this.table;  
		int newCapacity = oldTable.length * 2;  
		HashTableEntry[] newTable = new HashTableEntry[newCapacity];  
		this.table = newTable;  
		this.size = 0;  
			for (HashTableEntry element : oldTable) {  
				if (element != null) {  
					add(element.key, element.value);  
					
			        }  
			    }  
			}

	public String get(String key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % this.table.length;

		HashTableEntry currentEntry = this.table[index];
		while (currentEntry != null) {
			if (currentEntry.removed == false && currentEntry.key.equals(key)) {
				return currentEntry.value;
			}

			index++;

			if (index >= this.table.length) {
				index = 0;
			}

			currentEntry = this.table[index];
		}

		throw new RuntimeException("Elemento não está presente.");
	}

	@Override
	public void remove(String key) {
	    int hashCode = Math.abs(key.hashCode());
	    int index = hashCode % this.table.length;
	    int startIndex = index; 

	    HashTableEntry currentEntry = this.table[index];
	    
	    while (currentEntry != null) {

	        if (!currentEntry.removed && currentEntry.key.equals(key)) {
	            currentEntry.removed = true; 
	            this.size--; 
	            System.out.println("Removido com sucesso");
	            return;
	        }
  
	        index++;
	        
	        if (index >= this.table.length) {
	            index = 0;
	        }

	        if (index == startIndex) {
	            break;
	        }

	        currentEntry = this.table[index]; 
	    }

	    throw new RuntimeException("Elemento não encontrado");
	}


	@Override
	public int getSize() {
		return size;
	}

	private class HashTableEntry {
		String key;
		String value;
		Boolean removed;

		public HashTableEntry(String key, String value) {
			this.key = key;
			this.value = value;
			this.removed = false;
		}
	}

	public static void main(String[] args) {
		HashTable hashTable = new HashTable();
		hashTable.add("10", "0");
		hashTable.add("kamila", "adriel");
		hashTable.add("carro", "cavalo");
		hashTable.add("algoritmos e estruturas de dados", "AMO!!!!!");
		hashTable.add("javascript", "666");
		hashTable.add("python", ";");
		hashTable.add("C++", ";");
		hashTable.add("boi", "voador");
		hashTable.add("IFPE", "morcego");
		hashTable.remove("javascript");
		System.out.print(hashTable.get("carro"));

	}

}
