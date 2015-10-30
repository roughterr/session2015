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
        private static ArrayList allTheBooks { get; set; }

        private static ShowAllBooksForm showAllBooksForm;

        public Form1()
        {
            InitializeComponent();
            showAllBooksForm = new ShowAllBooksForm();
            allTheBooks = new ArrayList();
            Book book1 = new Book("David Copperfield", "Charles Dickens");
            allTheBooks.Add(book1);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            showAllBooksForm.Show();
        }
    }
}
