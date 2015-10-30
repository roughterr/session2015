using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Marthe
{
    class ShowAllBooksForm : Form
    {
        private RichTextBox richTextBox1;
    
        public ShowAllBooksForm()
        {
            InitializeComponent();
        }

        private void InitializeComponent()
        {
            this.richTextBox1 = new System.Windows.Forms.RichTextBox();
            this.SuspendLayout();
            // 
            // richTextBox1
            // 
            this.richTextBox1.Location = new System.Drawing.Point(12, 12);
            this.richTextBox1.Name = "richTextBox1";
            this.richTextBox1.Size = new System.Drawing.Size(258, 96);
            this.richTextBox1.TabIndex = 1;
            this.richTextBox1.Text = "awwawa";
            this.richTextBox1.TextChanged += new System.EventHandler(this.richTextBox1_TextChanged);
            // 
            // ShowAllBooksForm
            // 
            this.ClientSize = new System.Drawing.Size(282, 253);
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
    }
}
