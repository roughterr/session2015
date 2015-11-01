using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

///Represents a book
namespace WindowsFormsApplication1
{
    public class Book
    {
        public Book(string title, string author) {
            this.title = title;
            this.author = author;
        }
        /// <summary>
        /// Назва книжки
        /// </summary>
        public string title { get; set; }
        /// <summary>
        /// Автор книжки
        /// </summary>
        public string author { get; set; }
    }
}
