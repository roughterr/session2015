using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Collections;

namespace Marthe
{
    public class ShowAllBooksForm : Form
    {
        private Button button1;
        private RichTextBox richTextBox1;
    
        public ShowAllBooksForm()
        {
            InitializeComponent();
        }

        private void InitializeComponent()
        {
            this.richTextBox1 = new System.Windows.Forms.RichTextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // richTextBox1
            // 
            this.richTextBox1.Location = new System.Drawing.Point(12, 12);
            this.richTextBox1.Name = "richTextBox1";
            this.richTextBox1.Size = new System.Drawing.Size(400, 96);
            this.richTextBox1.TabIndex = 1;
            //this.richTextBox1.Text = "0";
            //Book book1 = new Book("David Copperfield", "Charles Dickens");
            //Book book2 = new Book("Tess of the d'Urbervilles", "Thomas Hardy");
            //AllBooks.BookList.Add(book1);
            //AllBooks.BookList.Add(book2);
            this.richTextBox1.TextChanged += new System.EventHandler(this.richTextBox1_TextChanged);
            // 
            // button1
            // 
            for (int i = 0; i < AllBooks.BookList.Count; i++)
            {
                Book book = AllBooks.BookList[i];
                this.richTextBox1.Text += "Title: " + book.title + ", author: " + book.author + "\n";
            }
            this.button1.Location = new System.Drawing.Point(149, 172);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 2;
            this.button1.Text = "close";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // ShowAllBooksForm
            // 
            this.ClientSize = new System.Drawing.Size(282, 253);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.richTextBox1);
            this.Name = "ShowAllBooksForm";
            this.ResumeLayout(false);

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Hide();
        }
    }
}
