using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    /// <summary>
    /// Предоставление информации о названиях книг и их авторов;
    /// </summary>
    class ShowBooksForm : Form
    {
        public ShowBooksForm() {
            InitializeComponent();
        }

        private TextBox textBox1;

        private void InitializeComponent()
        {
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(12, 12);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(258, 22);
            this.textBox1.TabIndex = 0;
            this.textBox1.Text = "Hi World!";
            this.textBox1.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // ShowBooksForm
            // 
            this.ClientSize = new System.Drawing.Size(282, 253);
            this.Controls.Add(this.textBox1);
            this.Name = "ShowBooksForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }

    /// <summary>
    /// Містить усі книжки
    /// </summary>
    /*public class AllBooks
    {
        public static List<Book> getBooks()
        {
            return null;
        }

        public static List<Book> allBooks { get; set; }

        public static void addDefaultBooks()
        {
            //allBooks.Add(new Book("Ivanhoe", "Walter Scott"));
        }
    }*/
}
