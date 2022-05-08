import java.util.Scanner;//biblioteca para escanear e o usuario colocar a mensagem
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainReserva {

	public static void main(String[] args) {
		
		Scanner leitura = new Scanner(System.in);//variavel escanear entrada teclado
		
		Calendar cal1 = Calendar.getInstance();//variavel calendario para instanciar
		Calendar cal2 = Calendar.getInstance();	//variavel calendario para instanciar
		Calendar cal3 = Calendar.getInstance();//variavel calendario para instanciar
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");//variavel formatacao de datas
		
		
		
		String cliente= new String();
		String data1= new String();
		String data2= new String();
		String data3= new String();
		
		Hotel Lakewood = new Hotel();
		Hotel Bridgewood = new Hotel();
		Hotel Ridgewood = new Hotel();
		
		float PrecoLAK=0;
		float PrecoBRIG=0;
		float PrecoRID=0;
		
		
		Lakewood.inserirDados(3, 110, 80, 90, 80, "Lakewood");
		Bridgewood.inserirDados(4, 160, 110, 60, 50, "Bridgewood");
		Ridgewood.inserirDados(5, 220, 100, 150, 40, "Ridgewood");


		System.out.println("Qual o tipo de Cliente?(Regular - Digite 0 ,Reward - Digite 1)");
		cliente = leitura.nextLine();
		
		System.out.println("Digite a Data1 (Utilize o formato dd/MM/aaaa)");
		data1 = leitura.nextLine();
		try {
		cal1.setTime(simpleFormat.parse(data1));
		}
		catch (ParseException e){e.printStackTrace();}
			
	
		
		System.out.println("Digite a Data2 (Utilize o formato dd/MM/aaaa)");
		data2 = leitura.nextLine();
		
		try {
		cal2.setTime(simpleFormat.parse(data2));
		}
		catch (ParseException e){e.printStackTrace();}
		
		System.out.println("Digite a Data3 (Utilize o formato dd/MM/aaaa)");
		data3 = leitura.nextLine();
		try {
		cal3.setTime(simpleFormat.parse(data3));
		}
		catch (ParseException e){e.printStackTrace();}
		
		
		if(cliente=="0") {//Cliente Regular
		
		
												if (checaFDS(cal1)==0) {//final de semana
													
													 PrecoLAK=Lakewood.taxa_fds_normal;
													 PrecoBRIG=Bridgewood.taxa_fds_normal;
													 PrecoRID=Ridgewood.taxa_fds_normal;
														
													
												}else {//dia de semana
													
													 PrecoLAK=Lakewood.taxa_normal;
													 PrecoBRIG=Bridgewood.taxa_normal;
													 PrecoRID=Ridgewood.taxa_normal;
													
												}
												
												if (checaFDS(cal2)==0) {//final de semana
													
												     PrecoLAK+=Lakewood.taxa_fds_normal;
													 PrecoBRIG+=Bridgewood.taxa_fds_normal;
													 PrecoRID+=Ridgewood.taxa_fds_normal;
																
															
												}else {//dia de semana
													
													 PrecoLAK+=Lakewood.taxa_normal;
													 PrecoBRIG+=Bridgewood.taxa_normal;
													 PrecoRID+=Ridgewood.taxa_normal;
															 
															
												}
										
										
												if (checaFDS(cal3)==0) {//final de semana
													
													 PrecoLAK+=Lakewood.taxa_fds_normal;
													 PrecoBRIG+=Bridgewood.taxa_fds_normal;
													 PrecoRID+=Ridgewood.taxa_fds_normal;
													
												}else {//dia de semana
													
													 PrecoLAK+=Lakewood.taxa_normal;
													 PrecoBRIG+=Bridgewood.taxa_normal;
													 PrecoRID+=Ridgewood.taxa_normal;
													
												}
												
												
												
												
		}else {//Cliente Reward
			
			
												if (checaFDS(cal1)==0) {//final de semana
													
													 PrecoLAK=Lakewood.taxa_fds_fidelidade;
													 PrecoBRIG=Bridgewood.taxa_fds_fidelidade;
													 PrecoRID=Ridgewood.taxa_fds_fidelidade;
													
													
												}else {//dia de semana
													
													 PrecoLAK=Lakewood.taxa_fidelidade;
													 PrecoBRIG=Bridgewood.taxa_fidelidade;
													 PrecoRID=Ridgewood.taxa_fidelidade;
													
												}
												
												if (checaFDS(cal2)==0) {//final de semana
													
													 PrecoLAK+=Lakewood.taxa_fds_fidelidade;
													 PrecoBRIG+=Bridgewood.taxa_fds_fidelidade;
													 PrecoRID+=Ridgewood.taxa_fds_fidelidade;
																
															
												}else {//dia de semana
													
													 PrecoLAK+=Lakewood.taxa_fidelidade;
													 PrecoBRIG+=Bridgewood.taxa_fidelidade;
													 PrecoRID+=Ridgewood.taxa_fidelidade;
															
															
												}
										
										
												if (checaFDS(cal3)==0) {//final de semana
													
													 PrecoLAK+=Lakewood.taxa_fds_fidelidade;
													 PrecoBRIG+=Bridgewood.taxa_fds_fidelidade;
													 PrecoRID+=Ridgewood.taxa_fds_fidelidade;
													
												}else {//dia de semana
													
													 PrecoLAK+=Lakewood.taxa_fidelidade;
													 PrecoBRIG+=Bridgewood.taxa_fidelidade;
													 PrecoRID+=Ridgewood.taxa_fidelidade;
													
												}
				
			
		}
		
		
		if((PrecoLAK<PrecoBRIG) || (PrecoLAK<PrecoRID)) {
			
			System.out.println("Lakewood");
		}else if ((PrecoBRIG<PrecoLAK)||(PrecoBRIG<PrecoRID)){
			System.out.println("Brigdewood");
			}else if((PrecoRID<PrecoLAK)||(PrecoRID<PrecoBRIG)) {
				System.out.println("Ridgewood");	
			}else if((PrecoLAK==PrecoBRIG)) {
				
				System.out.println("Brigdewood");
				}else if((PrecoBRIG==PrecoRID)) {
					
					System.out.println("Ridgewood");
					}else if((PrecoLAK==PrecoRID)) {
						
						System.out.println("Ridgewood");
						}


	}
	
    public static int checaFDS(Calendar data)
    {
        // se for domingo
        if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
        {
            data.add(Calendar.DATE, 1);
            return 0;
        }
        // se for sábado
        else if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
        {
            data.add(Calendar.DATE, 2);
            return 0;
        }
        else
      
        	return 1;
    }

}
