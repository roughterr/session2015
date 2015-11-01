using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

using System.Collections;

namespace BookShop
{
    public partial class Form1 : Form
    {
        public static ShowAllBooks2 showAllBooksForm2;
        public static AddBookForm addBookForm;

        public Form1()
        {
            InitializeComponent();
            Book book1 = new Book("David Copperfield", "Charles Dickens");
            Book book2 = new Book("Tess of the d'Urbervilles", "Thomas Hardy");
            AllBooks.BookList.Add(book1);
            AllBooks.BookList.Add(book2);
        }

        private void button2_Click_1(object sender, EventArgs e)
        {
            addBookForm = new AddBookForm();
            addBookForm.Show();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            showAllBooksForm2 = new ShowAllBooks2();
            showAllBooksForm2.Show();
        }
    }
}
