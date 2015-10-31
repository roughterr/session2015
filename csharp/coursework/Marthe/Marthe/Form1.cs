using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

using System.Collections;

namespace Marthe
{
    public partial class Form1 : Form
    {
        public static ShowAllBooksForm showAllBooksForm;
        public static AddBookForm addBookForm;

        public Form1()
        {
            InitializeComponent();
            Book book1 = new Book("David Copperfield", "Charles Dickens");
            Book book2 = new Book("Tess of the d'Urbervilles", "Thomas Hardy");
            AllBooks.BookList.Add(book1);
            AllBooks.BookList.Add(book2);
            
            //AllBooks.BookList = new List<Book>();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            //Book book1 = new Book("David Copperfield", "Charles Dickens");
            //AllBooks.BookList.Add(book1);
            //Book book2 = new Book("Tess of the d'Urbervilles", "Thomas Hardy");
            //AllBooks.BookList.Add(book2);
            showAllBooksForm = new ShowAllBooksForm();
            showAllBooksForm.Show();
        }

        private void button2_Click_1(object sender, EventArgs e)
        {
            addBookForm = new AddBookForm();
            addBookForm.Show();
        }
    }
}
