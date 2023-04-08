using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;
using System.IO;

namespace incercare_tema
{
    public partial class Form1 : Form
    {
        DataTable dt;
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            

            comboBox1.Items.Add("Beagle");
            comboBox1.Items.Add("Yorkshire");
            comboBox1.Items.Add("British");
            comboBox1.Items.Add("Sphynx");
            comboBox1.Items.Add("Roborovski");
            comboBox1.Items.Add("Syrian");
            comboBox1.Items.Add("African Grey");
            comboBox1.Items.Add("Macaws");

             dt = new DataTable();
            dt.Columns.Add("Nume");
            dt.Columns.Add("Rasa");
            dt.Columns.Add("Sex");
            dt.Columns.Add("Varsta");
            dt.Columns.Add("Pret(EUR)");
            dt.Columns.Add("Descriere");
            

            dt.Rows.Add("Max", "Beagle","M", "2 ani","200", "El este Max, un beagle de 2 ani si 3 luni cu pedigree.Are nevoie de spațiu, iubire si o familie intelegatoare. Este cuminte,prietenoasa,jucaus si mereu plin de viata.");
            dt.Rows.Add("Cody", "British", "M", "1 an", "150", " Cody un animal pe cât de inteligent, pe atât de activ și jucăuș, iar cel mic va fi foarte încântat să-și petreacă timpul în prezența ei. Această pisică este un adevărat argint viu.");
            dt.Rows.Add("Kitty", "British", "F", "1 an","150", " Kitty un animal pe cât de inteligent, pe atât de activ și jucăuș, iar cel mic va fi foarte încântat să-și petreacă timpul în prezența ei. Această pisică este un adevărat argint viu.");
            dt.Rows.Add("Yoyo", "Yorkshire", "F", "3 ani", "300", "Mica, agila și foarte loiala,Yoyo,se înțelege bine atât cu copiii, cât și cu adulții. Poate fi o minunată bonă cu patru picioare, însoțitoare și prietenă loială. Jucăușa și foarte vesela,se distinge prin bunătate și răbdare.");
            dt.Rows.Add("Toby", "Yorkshire", "M", "4 ani","300", "Mic, agil și foarte de loial,Toby,se înțelege bine atât cu copiii, cât și cu adulții. Poate fi o minunată bonă cu patru picioare, însoțitoare și prietenă loială. Jucăuș și foarte vesel,se distinge prin bunătate și răbdare.");
            dt.Rows.Add("Henry", "Macaws", "M", "2 ani", "100", "Henry una dintre cele mai prietenoase specii de papagali avand un comportament plin de viata si de energie. Sunt jucausi, zgomotosi si adeseori pot deveni distructivi daca nu sunt ingrijiti corespunzator. ");
            dt.Rows.Add("Heidi", "Macaws", "F", "3 ani","120", "Heidi una dintre cele mai prietenoase specii de papagali avand un comportament plin de viata si de energie. Sunt jucausi, zgomotosi si adeseori pot deveni distructivi daca nu sunt ingrijiti corespunzator. ");
            dt.Rows.Add("Goofy", "Syrian", "M", "3 ani", "70", "Goofy este denumit hamsterul cu ursuleț de pluș, deoarece are aspectul drăguț al jucăriței de peluză a unui copil, dar și pentru că este receptiv la a fi îmbrățișat și ținut de oamenii săi.");
            dt.Rows.Add("Loly", "Syrian", "F", "2 ani","80", "Loly este denumita hamsterul cu ursuleț de pluș, deoarece are aspectul drăguț al jucăriei a unui copil, dar și pentru că este receptiv la a fi îmbrățișata și ținuta de oamenii săi.");
            dt.Rows.Add("Mimi", "Sphynx", "F", "3 ani","400", "Aceasta pisicuta este ideală pentru familiile cu copii deoarece este un animal de companie activ, jucăuș, energic și prietenos cu cei mici.Mimi adoră să sară, să țopăie, este curioasă și agilă.");
            dt.Rows.Add("Aldo", "Sphynx", "M", "2 ani", "450", "Aceasta pisicuta este perfecta pentru familiile cu copii deoarece este un animal de companie activ, jucăuș, energic și prietenos cu cei mici.Mimi adoră să sară, să țopăie, este spontana și agilă.");
            dt.Rows.Add("Cora", "Roborovski", "F", "2 ani", "150", " Are picioarele mai lungi decat alte specii de hamsteri pitici. Este foarte adaptat la conditiile de desert, avand rinichi eficienti si produce foarte putina urina.");
            dt.Rows.Add("Dean", "Roborovski", "M", "1 an", "150", " Are piciorusele mai lungi decat alte specii de hamsteri pitici. Este foarte adaptat la conditiile de desert, avand rinichi eficienti si produce foarte putina urina.");
            dt.Rows.Add("Dino", "African Grey", "M", "1 an", "150", "Papagalul gri african Timneh, are un coloritul cenușiu închis, pe burtă cenușiu deschis, coada roșu - vișiniu închis, ciocul negru cu partea de sus maro deschis și picioarele negre - cenușii.\r\n");
            dt.Rows.Add("Sindy", "African Grey", "F", "1 an", "150", "Sindy, are o culoare cenușiu închis, pe burtă cenușiu deschis, coada roșu - vișiniu închis, ciocul negru cu partea de sus maro deschis și picioarele negre - cenușii.\r\n");


            listView1_cos.Columns.Add("Nume");
            listView1_cos.Columns.Add("Pret(EUR)");

            // setez dataTableu ca sursa pentru dataView
            dataGridView1.DataSource = dt;

            foreach (DataRow row in dt.Rows)
            {
                string rasa = row["Rasa"].ToString();
                if (!comboBox1.Items.Contains(rasa))
                {
                    comboBox1.Items.Add(rasa);
                }
            }

            this.radioButtonMasculin.CheckedChanged += new System.EventHandler(this.radioButton_CheckedChanged);

            this.radioButtonFeminin.CheckedChanged += new System.EventHandler(this.radioButton_CheckedChanged);


        }

        private void radioButton_CheckedChanged(object sender, EventArgs e)
        {
            string filt = string.Empty;
            if (radioButtonMasculin.Checked)
            {
                filt = "[Sex] = 'M'";
            }
            else if (radioButtonFeminin.Checked)
            {
                filt = "[Sex] = 'F'";
            }

            
            if (comboBox1.SelectedItem != null)
            {
                string selectedValue = comboBox1.SelectedItem.ToString();
                filt += string.IsNullOrEmpty(filt) ? string.Empty : " AND ";
                filt += $"[Rasa] = '{selectedValue}'";
            }

            
             (dataGridView1.DataSource as DataTable).DefaultView.RowFilter = filt;

           
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.AllCells;
            dataGridView1.AutoSizeRowsMode = DataGridViewAutoSizeRowsMode.AllCells;

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            // fltrez DataTableu in functie de valoarea selectata în comboBox.
            string selectedValue = comboBox1.SelectedItem.ToString();
            (dataGridView1.DataSource as DataTable).DefaultView.RowFilter = $"[Rasa] = '{selectedValue}'";

            // reinitializez coloanele și randurile dataView ului.
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.AllCells;
            dataGridView1.AutoSizeRowsMode = DataGridViewAutoSizeRowsMode.AllCells;
            radioButton_CheckedChanged(sender, e);

        }

        
        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void CautaAnimale(string numeAnimal)
        {
          
        }

        private void button1_adaugaCos_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                DataGridViewRow dataGridViewRow = dataGridView1.SelectedRows[0];

                string nume = dataGridViewRow.Cells[0].Value.ToString();
                Double pret = Convert.ToDouble(dataGridViewRow.Cells[4].Value);

                ListViewItem item = new ListViewItem(nume);
                item.SubItems.Add(pret.ToString());
                listView1_cos.Items.Add(item);
                listView1_cos.AutoResizeColumns(ColumnHeaderAutoResizeStyle.HeaderSize);

            }
            else
            {
                MessageBox.Show("Selectați un rând din tabelul de animale pentru a-l adăuga în coșul de cumpărături.");
            }

        }
        private void listView1_cos_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void pictureBox1_imagineAnimal_Click(object sender, EventArgs e)
        {

        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            DataGridViewRow row = dataGridView1.Rows[e.RowIndex];

            string nume = row.Cells[0].Value.ToString();      
            pictureBox1_imagineAnimal.Image = Image.FromFile("C:\\Users\\Vasilica\\Desktop\\C#_II\\incercare_tema\\incercare_tema\\bin\\Debug\\" + nume + ".jpg");
            pictureBox1_imagineAnimal.SizeMode = PictureBoxSizeMode.StretchImage;

            string descriere = row.Cells[5].Value.ToString();
            textBox1_descriere.Text = descriere;               
        }

        private void textBox1_descriere_TextChanged(object sender, EventArgs e)
        {
            
        }

        private void button1_save_Click(object sender, EventArgs e)
        {

            using (StreamWriter sw = new StreamWriter("cos.txt"))
            {
                foreach (ListViewItem item in listView1_cos.Items)
                {
                    sw.WriteLine($"{item.SubItems[0].Text} - {item.SubItems[1].Text}");
                }

                int suma = 0;
               
                for (int i = 0; i < listView1_cos.Items.Count; i++)
                {
                    int sum;
                    if (int.TryParse(listView1_cos.Items[i].SubItems[1].Text, out sum))
                {
                    suma += sum;
                }
                else
                {
                    MessageBox.Show($"Valoarea {listView1_cos.Items[i].SubItems[1].Text} nu poate fi convertita într-un nr intreg.", "eroare");
                }
                }
                sw.WriteLine($"Totalul este: {suma.ToString("N2")} EURO");
               

            }

        }
    }
    }

