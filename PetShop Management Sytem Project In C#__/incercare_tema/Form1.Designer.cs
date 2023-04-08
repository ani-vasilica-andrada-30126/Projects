namespace incercare_tema
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.comboBox1 = new System.Windows.Forms.ComboBox();
            this.backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.button1_adaugaCos = new System.Windows.Forms.Button();
            this.listView1_cos = new System.Windows.Forms.ListView();
            this.pictureBox1_imagineAnimal = new System.Windows.Forms.PictureBox();
            this.textBox1_descriere = new System.Windows.Forms.TextBox();
            this.radioButtonFeminin = new System.Windows.Forms.RadioButton();
            this.radioButtonMasculin = new System.Windows.Forms.RadioButton();
            this.label1 = new System.Windows.Forms.Label();
            this.button1_save = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1_imagineAnimal)).BeginInit();
            this.SuspendLayout();
            // 
            // comboBox1
            // 
            this.comboBox1.BackColor = System.Drawing.Color.LightPink;
            this.comboBox1.FormattingEnabled = true;
            this.comboBox1.Location = new System.Drawing.Point(20, 65);
            this.comboBox1.Name = "comboBox1";
            this.comboBox1.Size = new System.Drawing.Size(260, 24);
            this.comboBox1.TabIndex = 0;
            this.comboBox1.SelectedIndexChanged += new System.EventHandler(this.comboBox1_SelectedIndexChanged);
            // 
            // dataGridView1
            // 
            this.dataGridView1.BackgroundColor = System.Drawing.Color.LavenderBlush;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(20, 108);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.RowHeadersWidth = 51;
            this.dataGridView1.RowTemplate.Height = 24;
            this.dataGridView1.Size = new System.Drawing.Size(520, 121);
            this.dataGridView1.TabIndex = 2;
            this.dataGridView1.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellClick);
            this.dataGridView1.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellContentClick);
            // 
            // button1_adaugaCos
            // 
            this.button1_adaugaCos.BackColor = System.Drawing.Color.Pink;
            this.button1_adaugaCos.Location = new System.Drawing.Point(609, 127);
            this.button1_adaugaCos.Name = "button1_adaugaCos";
            this.button1_adaugaCos.Size = new System.Drawing.Size(95, 33);
            this.button1_adaugaCos.TabIndex = 3;
            this.button1_adaugaCos.Text = "Adauga";
            this.button1_adaugaCos.UseVisualStyleBackColor = false;
            this.button1_adaugaCos.Click += new System.EventHandler(this.button1_adaugaCos_Click);
            // 
            // listView1_cos
            // 
            this.listView1_cos.BackColor = System.Drawing.Color.MistyRose;
            this.listView1_cos.HideSelection = false;
            this.listView1_cos.Location = new System.Drawing.Point(558, 256);
            this.listView1_cos.Name = "listView1_cos";
            this.listView1_cos.Size = new System.Drawing.Size(230, 133);
            this.listView1_cos.TabIndex = 4;
            this.listView1_cos.UseCompatibleStateImageBehavior = false;
            this.listView1_cos.View = System.Windows.Forms.View.Details;
            this.listView1_cos.SelectedIndexChanged += new System.EventHandler(this.listView1_cos_SelectedIndexChanged);
            // 
            // pictureBox1_imagineAnimal
            // 
            this.pictureBox1_imagineAnimal.BackColor = System.Drawing.Color.Snow;
            this.pictureBox1_imagineAnimal.Location = new System.Drawing.Point(318, 246);
            this.pictureBox1_imagineAnimal.Name = "pictureBox1_imagineAnimal";
            this.pictureBox1_imagineAnimal.Size = new System.Drawing.Size(222, 203);
            this.pictureBox1_imagineAnimal.TabIndex = 5;
            this.pictureBox1_imagineAnimal.TabStop = false;
            this.pictureBox1_imagineAnimal.Click += new System.EventHandler(this.pictureBox1_imagineAnimal_Click);
            // 
            // textBox1_descriere
            // 
            this.textBox1_descriere.BackColor = System.Drawing.Color.MistyRose;
            this.textBox1_descriere.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.textBox1_descriere.Location = new System.Drawing.Point(20, 256);
            this.textBox1_descriere.MaxLength = 30000;
            this.textBox1_descriere.Multiline = true;
            this.textBox1_descriere.Name = "textBox1_descriere";
            this.textBox1_descriere.Size = new System.Drawing.Size(281, 163);
            this.textBox1_descriere.TabIndex = 6;
            this.textBox1_descriere.TextChanged += new System.EventHandler(this.textBox1_descriere_TextChanged);
            // 
            // radioButtonFeminin
            // 
            this.radioButtonFeminin.AutoSize = true;
            this.radioButtonFeminin.Location = new System.Drawing.Point(329, 69);
            this.radioButtonFeminin.Name = "radioButtonFeminin";
            this.radioButtonFeminin.Size = new System.Drawing.Size(36, 20);
            this.radioButtonFeminin.TabIndex = 7;
            this.radioButtonFeminin.TabStop = true;
            this.radioButtonFeminin.Text = "F";
            this.radioButtonFeminin.UseVisualStyleBackColor = true;
            // 
            // radioButtonMasculin
            // 
            this.radioButtonMasculin.AutoSize = true;
            this.radioButtonMasculin.Location = new System.Drawing.Point(400, 69);
            this.radioButtonMasculin.Name = "radioButtonMasculin";
            this.radioButtonMasculin.Size = new System.Drawing.Size(39, 20);
            this.radioButtonMasculin.TabIndex = 8;
            this.radioButtonMasculin.TabStop = true;
            this.radioButtonMasculin.Text = "M";
            this.radioButtonMasculin.UseVisualStyleBackColor = true;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.Snow;
            this.label1.Font = new System.Drawing.Font("High Tower Text", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.MediumVioletRed;
            this.label1.Location = new System.Drawing.Point(321, -3);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(168, 48);
            this.label1.TabIndex = 9;
            this.label1.Text = "PetShop";
            // 
            // button1_save
            // 
            this.button1_save.Location = new System.Drawing.Point(610, 183);
            this.button1_save.Name = "button1_save";
            this.button1_save.Size = new System.Drawing.Size(93, 28);
            this.button1_save.TabIndex = 10;
            this.button1_save.Text = "Salveaza";
            this.button1_save.UseVisualStyleBackColor = true;
            this.button1_save.Click += new System.EventHandler(this.button1_save_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.LavenderBlush;
            this.ClientSize = new System.Drawing.Size(821, 478);
            this.Controls.Add(this.button1_save);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.radioButtonMasculin);
            this.Controls.Add(this.radioButtonFeminin);
            this.Controls.Add(this.textBox1_descriere);
            this.Controls.Add(this.pictureBox1_imagineAnimal);
            this.Controls.Add(this.listView1_cos);
            this.Controls.Add(this.button1_adaugaCos);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.comboBox1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1_imagineAnimal)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ComboBox comboBox1;
        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.Button button1_adaugaCos;
        private System.Windows.Forms.ListView listView1_cos;
        private System.Windows.Forms.PictureBox pictureBox1_imagineAnimal;
        private System.Windows.Forms.TextBox textBox1_descriere;
        private System.Windows.Forms.RadioButton radioButtonFeminin;
        private System.Windows.Forms.RadioButton radioButtonMasculin;
        public System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button button1_save;
    }
}

