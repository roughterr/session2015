using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Drawing;

namespace BookShop
{
    public class AreYouSureDeleteBook : Form
    {
        private Book bookInQuestion;

        public AreYouSureDeleteBook(Book bookInQuestion)
        {
            this.bookInQuestion = bookInQuestion;
            Button button = new Button();
            button.Text = "Так.";
            button.Location = new Point(10, 10);
            button.Height = 40;
            button.Width = 40;
            button.Click += new EventHandler(yesClick);
            this.Controls.Add(button);
            //no
            Button noButton = new Button();
            noButton.Text = "Ні.";
            noButton.Location = new Point(60, 10);
            noButton.Height = 40;
            noButton.Width = 40;
            noButton.Click += new EventHandler(noClick);
            this.Controls.Add(noButton);
        }

        private void yesClick(object sender, EventArgs e)
        {
            AllBooks.BookList.Remove(bookInQuestion);
            Form1.showAllBooksForm2.Controls.Clear();
            Form1.showAllBooksForm2.InitializeComponent();
            this.Hide();
        }

        private void noClick(object sender, EventArgs e)
        {
            this.Hide();
        }
    }

    class ButtonDeleteBook : Button
    {
        /// <summary>
        /// Книга, яка може бути видалена
        /// </summary>
        public Book bookInQuestion;
        /// <summary>
        /// Конструктор.
        /// </summary>
        /// <param name="bookInQuestion"></param>
        public ButtonDeleteBook(Book bookInQuestion)
        {
            this.bookInQuestion = bookInQuestion;
            this.Click += new System.EventHandler(this.ButtonSubclass_Click);
        }

        private void ButtonSubclass_Click(object sender, EventArgs e)
        {
            //AllBooks.BookList.Remove(bookInQuestion);
            AreYouSureDeleteBook areYouSureDeleteBook = new AreYouSureDeleteBook(bookInQuestion);
            areYouSureDeleteBook.Show();
            //Form1.addBookForm.Hide();
            //Form1.
            //this.Hide();
        }
    }

    public class ShowAllBooks2 : Form
    {
        public ShowAllBooks2()
        {
            InitializeComponent();
        }

        private Button button1;

        public void InitializeComponent()
        {
            this.button1 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(13, 13);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 0;
            this.button1.Text = "Закрити";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.buttonClose_Click);
            // 
            // ShowAllBooks2
            // 
            this.ClientSize = new System.Drawing.Size(284, 261);
            this.Controls.Add(this.button1);
            this.Name = "ShowAllBooks2";
            this.ResumeLayout(false);
            //
            for (int i = 0; i < AllBooks.BookList.Count; i++)
            {
                Book book = AllBooks.BookList[i];
                //Button button = new Button();
                Button button = new ButtonDeleteBook(book);
                button.Text = "Видалити цю книгу";
                button.Location = new Point(16, 50 * i + 100);
                button.Height = 40;
                button.Width = 100;
                button.Tag = i;
                this.Controls.Add(button);
                //назва книги
                Label tempLab = new Label();
                tempLab.Text = "Назва книги: " + book.title + "\n" + "Автор книги: " + book.author;
                tempLab.Location = new Point(120, 50 * i + 105);
                tempLab.Height = 40;
                tempLab.Width = 400;
                this.Controls.Add(tempLab);
            }
        }

        private void buttonClose_Click(object sender, EventArgs e)
        {
            this.Hide();
        }
    }
}
