using System;

namespace WorkWithFile
{
	public class Employer
	{
		private String Family;//фамилия имя отчество работника
		private double salary;//размер зарплаты
		//конструктор с параметрами
		public Employer (String name, double salary)
		{
			this.Family = name;
			this.salary = salary;
		}
		//получить информацию про работника для записи в файл
		public String forPrint(){
			return Family + ":" +Convert.ToString (salary);
		}
		//получить информацию про зарплату 
		public double getSalary(){
			return this.salary;
		}
	}
}

