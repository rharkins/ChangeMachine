using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace ChangeApp
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private Dictionary<string, Decimal> CURRECNY_VALUES = new Dictionary<string, Decimal>() { { "Hundreds", new Decimal(100.00) }, { "Fifties", new Decimal(50.00) }, { "Twenties", new Decimal(20.00) }, 
            { "Tens", new Decimal(10.00) }, { "Fives", new Decimal(5.00) }, { "Ones", new Decimal(1.00) }, { "Quarters", new Decimal(0.25) }, { "Dimes", new Decimal(0.10) }, { "Nickles", new Decimal(0.05) }, { "Pennies", new Decimal(0.01) } };

        private void txbAmount_TextChanged_1(object sender, TextChangedEventArgs e)
        {
            lblChangeBreakdown.Content = "";
            lblMessage.Content = "";
            string amount = ((TextBox)sender).Text;
            Decimal parsedAmount = new Decimal(0.0);
            if (isValidAmount(amount, ref parsedAmount))
            {
                lblMessage.Content = "";
                if (parsedAmount > 0)
                {
                    lblChangeBreakdown.Foreground = Brushes.Black;
                    calculateChange(parsedAmount);
                }
                else if (parsedAmount < 0)
                {
                    lblChangeBreakdown.Foreground = Brushes.Red;
                    lblChangeBreakdown.Content = "You Still Owe:";
                    calculateChange(parsedAmount * -1);
                }
                else
                {
                    lblChangeBreakdown.Content = "No Change Require";
                }
            }
            else
            {
                if (!string.IsNullOrEmpty(amount))
                {
                    lblMessage.Content = "Invalid Entry.  Must be a valid amount.";
                }
            }
        }

        private bool isValidAmount(string amount, ref Decimal results)
        {

            return Decimal.TryParse(amount, out results);
        }

        private void calculateChange(Decimal amount)
        {
            Dictionary<string, int> disbursement = new Dictionary<string, int>();
            foreach (KeyValuePair<string, Decimal> currencyPair in CURRECNY_VALUES)
            {
                int numValues = (int)(amount / currencyPair.Value);
                if (numValues > 0)
                {
                    disbursement.Add(currencyPair.Key, numValues);
                    amount -= (numValues * currencyPair.Value);
                }
            }
            diplayChange(disbursement);
        }

        private void diplayChange(Dictionary<string, int> dispersement)
        {
            foreach (KeyValuePair<string, int> pair in dispersement)
            {
                if (!string.IsNullOrEmpty((string)lblChangeBreakdown.Content))
                {
                    lblChangeBreakdown.Content += "\n";
                }
                lblChangeBreakdown.Content += pair.Key + ": " + pair.Value;
            }
        }
    }
}
