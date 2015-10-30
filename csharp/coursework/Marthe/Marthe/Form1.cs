using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Marthe
{
    public partial class Form1 : Form
    {
        private static ShowAllBooksForm showAllBooksForm;

        public Form1()
        {
            InitializeComponent();
            showAllBooksForm = new ShowAllBooksForm();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            showAllBooksForm.Show();
        }
    }
}
