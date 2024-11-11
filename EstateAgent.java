/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progthe_q2;
//https://github.com/fb-shaik/PROG6112-Group3-2023/tree/main/Zoo_Application_Interface code was adapted from github 
interface IEstateAgent {
   
double CalculateTotalCommission(String propertyPriceValue, String commissionPercentageValue);
boolean DataValidiation(String estateAgentNameValue, String Agentlocation, String propertyPrice, String CommissionPercentage);

}
public class EstateAgent implements IEstateAgent {

    @Override // methods hat calculates the amount of commission that will be charged 
    public double CalculateTotalCommission(String propertyPriceValue, String commissionPercentageValue) {
     Double Price = Double.parseDouble(propertyPriceValue) ;
     Double AgentCommission = Double.parseDouble(commissionPercentageValue) ;
     Double commission = (AgentCommission / 100) * Price; // Arthimetic calculation based on the user's comission percentage
     
        return commission ;
    }

    @Override//this method checks if all requirements are met when accepting users information 
    public boolean DataValidiation(String estateAgentNameValue, String Agentlocation, String propertyPrice, String CommissionPercentage) {
        // https://www.youtube.com/watch?v=-l1p55G4qGk code was adapted from this video 
        String name = estateAgentNameValue ;
        String location = Agentlocation ;
        Double price = Double.parseDouble(propertyPrice) ;
        Double commission = Double.parseDouble(CommissionPercentage) ;
        
         if (location.isEmpty()) {//checks is the location field is empty 
            return false;
        }

        // Check if the agent name is empty
        if (name.isEmpty()) {// checks if the name field is empty 
            return false;
        }

        // Check if the property price is valid
        try {
          
            if (price <= 0) {
                return false;// checks if the price of property is less than or equal to zero 
            }
        } catch (Exception e) {
            return false;
        }

        // Check if the commission percentage is less than or equal to zero 
        try {
            
            if (commission <= 0) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        
        return true;

    }

    
}
