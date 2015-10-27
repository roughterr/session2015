using System;
using WorkWithFile;
using System.IO;

namespace WorkWithFile
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			// path -> d:/folder/bd.txt d://folder//bd.txt
			//name of file bd.txt
			Console.Write("Path and/or name of file to write -> ");
			//считывание пути и имени файла, в который будет записана информация про работников
			String FilePath = Console.ReadLine();
			//создание объекта класса StreamWriter для записи информации про работника
			//в указаный файл, если он не существует он будет создан пустым
			//в противном случае откроеться существующий файл для добавления в конец информации про работника
			//из-за второго параметра конструктора true

			StreamWriter fileToWrite = null;
			try{
				fileToWrite = new StreamWriter(@FilePath, true);
				String next = "y";
					do{
						try{

							//список введенных работников
							Console.Write("Enter surname of employer :");
							String emSurName = "";
							emSurName = Console.ReadLine();
							//проверка на правильность введеной фамилии, фамилия должна начинаться с большой буквы 
							//и содержать только буквы алфавита
							//в противном случае генерируеться ошибка
								for(int k = 0; k < emSurName.Length;k++){
									if((!Char.IsLetter(emSurName[k]))||(Char.IsLower(emSurName[0]))) 
										throw new FormatException("Error surname of employer. Not all characters is letter or first letter of surname is lowercase");
									}
							
							Console.Write("Enter name of employer :");
							String emName = "";
							emName = Console.ReadLine();
							//проверка на правильность введеной имени, имя должно начинаться с большой буквы 
							//и содержать только буквы алфавита
							//в противном случае генерируеться ошибка
								for(int k = 0; k < emName.Length;k++){
									if((!Char.IsLetter(emName[k]))||(!Char.IsUpper(emName[0]))) 
										throw new FormatException("Error name of employer. Not all characters is letter or first letter of name is lowercase");
									}
							Console.Write("Enter salary [1200,0 .. 3000,0]");
							String sal = "";
							sal = Console.ReadLine();
							//проверка правильности введенной зароботной платы
							//в противном случае генерируеться ошибка
							Double salry=Convert.ToDouble(sal);
								if ((salry < 1200.0)||(salry > 3000.0)) throw new FormatException("Error number of salary");
							Console.Write("Add new employer y / n ");
							next = Console.ReadLine();
							Console.WriteLine();
							Employer listOfEmployer = new Employer(emSurName + " " + emName, salry);
							//запись в файл
							fileToWrite.WriteLine(listOfEmployer.forPrint());
					}
						catch(FormatException fEx){
							//обработка ошибки введения не верныех данных
							Console.WriteLine("Error data format {0}", fEx.Message);
							Console.WriteLine("Enter data again");
						}
						catch(IOException ioEx){
							//обработка ошибки записи в файл, если информация не записалась программа завершает свое выполнение
							Console.WriteLine ("Error writeline to file {0}", ioEx.Message);
							return;
						}
					}while(next.Equals("y"));
				//закрытие файла
				fileToWrite.Close();
				Console.WriteLine("Information was success write to file {0}", FilePath);
				}
				catch(DirectoryNotFoundException dnfEx){
					//ошибка создания файла
					//например не верно указан путь к файлу
					//если возникает эта ошибка, то программа завершает выполнение
					Console.WriteLine("Error path file {0}", dnfEx.Message);
					return;
				}
				catch(IOException ioEx){
					//ошибка ввода/вывода
					Console.WriteLine ("Error readLine 3 {0}", ioEx.Message);
					return;
				}
			//Полный путь к файлу - это расположение файла с его именем
			//если не указать путь к файлу, файл будет искаться в каталоге где расположен проект в каталоге /bin/Debug
			Console.Write("Path and/or name file to read -> ");
			FilePath = Console.ReadLine();
			StreamReader fileToread = null;
			//создание массива работников
			//индекс массива
			int index = 0;
			//количество работников в файле
			int numberOfEmployers = 0;
			//массив работников
			Employer[] employersFromFile = null;
			try{
				//откоытие файла, скоторого нужно считать информацию про работников
				fileToread = new StreamReader (@FilePath);
				//определение количиства работников в файле
				//прочитываеться весь файл до конца
				//с помощью метода split разделяем на строки по символу перевода строки \n 
				//определяем количество строк методом Length
				numberOfEmployers = fileToread.ReadToEnd().Split('\n').Length;
				//переопределение на начало файла
				fileToread = new StreamReader (@FilePath);
				//создание массива работников
				employersFromFile = new Employer[numberOfEmployers-1];
				//чтение по строчно информации про работника
				while(fileToread.EndOfStream != true){
					//занесение и разделение информации про работника
					//в массив str[] из двух елементтов заноситься 
					//фамилия и имя в str[0]
					//размер зароботной платы в str[1]
					//с помощью метода Split(char c) класса String разбиваем строку на массив з размером 2
					String [] str = fileToread.ReadLine().Split(':');
					//запись в массив работников через конструктор класса Employer(String, double)
					employersFromFile[index] = new Employer(str[0],Convert.ToDouble(str[1]));
					//увеличение индекса массива
					index++;
				}
				//закрытие файла
				fileToread.Close();
			}
			catch(FileNotFoundException fnfEx){
				//отлавливание ошибки FileNotFoundException
				//возникнет если файла нет
				Console.WriteLine("File no found. No resault for print {0}", fnfEx.Message);
				//щавершить программу так как он не прочтен
				return;
			}
			catch(IndexOutOfRangeException iorEx){
				//отлавливание ошибки IndexOutOfRangeException
				//при заполнении массива может возникнуть ситуация когда индекс массива больше количества элементов
				//массив работников объявлен с 50 элементами, если в файле будет больше 50 элементов 
				//тогда возникнет исключительная ситуация выхода за индекс массива
				Console.WriteLine("Index out of range array. To array was add only {0} elements {1}",numberOfEmployers, iorEx.Message);
			}
			catch(IOException ioEx){
				//отлавливание ошибки IOException
				//может возникнуть при записи или чтении файла
				Console.WriteLine ("Error read of file {0}", ioEx.Message);
			}

			try{
				//вывод работников у которых зароботная плата больше или равна 1500.0
			Console.WriteLine("List of employers which has salary hight of equls 1500:");
				for(int i = 0; i < index; i++){
				if(employersFromFile[i].getSalary() >= 1500.0){
					Console.WriteLine(employersFromFile[i].forPrint());
				}
			}
				Console.ReadKey ();
			}
			catch(NullReferenceException nrEx){
				//отлавливание ошибки NullReferenceException
				//если файл не был прочтен, то не заполнилась информация про работников в массив
				Console.WriteLine("Array of employers was't read from file. You can't see resualt. {0}", nrEx.Message);
			}


		}
	}
}
