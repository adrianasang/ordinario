package com.mayab.calidad.mockito;

public class AlumnoBD {
	
    public int id;
    public String name;
    public String lastName;
    public int age;
    public float avg;
    
    public AlumnoBD() {
        this.id = 0;
        this.name = "";
        this.lastName = "";
        this.age = 0;
        this.avg = 0.0f;
    }
    
    public AlumnoBD(int Id, String Name, String LastName, int Age, float AVG) {
        this.id = Id;
        this.name = Name;
        this.lastName = LastName;
        this.age = Age;
        this.avg = AVG;
    }
    
    public void setId(int Id) {this.id = Id;}
    public void setName(String Name) {this.name = Name;}
    public void setLastName(String LastName) {this.lastName = LastName;}
    public void setAge(int Age) {this.age = Age;}
    public void setAVG(float AVG) {this.avg = AVG;}
    
    public int getId() {return this.id;}
    public String getName() {return this.name;}
    public String getLastName() {return this.lastName;}
    public int getAge() {return this.age;}
    public float getAVG() {return this.avg;}
}
