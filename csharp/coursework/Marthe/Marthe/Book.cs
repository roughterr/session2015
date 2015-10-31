using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections;

namespace Marthe
{

    public static class AllBooks
    {
        static AllBooks()
        {
            BookList = new List<Book>();
        }
        public static List<Book> BookList { get; set; }
    }

    public class Book
    {
        public Book(string title, string author)
        {
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
        /// <summary>
        /// Вартість книги.
        /// </summary>
        public int price { get; set; }
    }
}
