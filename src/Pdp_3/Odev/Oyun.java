package Pdp_3.Odev;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;


public class Oyun {
	 
	     private ArrayList<Koloni> KoloniListesi;
	     private ArrayList<Koloni> tukenenKoloniler;
	     private AUretim uretim;
	     private ATaktik taktik;
	     private Koloni koloni1;
	     private Koloni koloni2;
	     private int turSayisi;
		 public Oyun(Koloni[] koloniler) {
			 KoloniListesi = new ArrayList<>();
			 
		      for (Koloni koloni : koloniler) {
		    	  KoloniListesi.add(koloni);
		    	  
		        }
		      tukenenKoloniler = new ArrayList<>();
		       turSayisi=0;
		 } 
		 
		 public void OyunTurDongusu() {
			 	boolean devam = true;
		        while (devam) {
		        	

		        	// Tüm koloniler için üretim yap ve yemek stoğunu güncelle
		        	 uretim = new AUretim();
		        	for (Koloni koloni : KoloniListesi) {
		                koloni.uretimYap(uretim);
		            }
		            	
		            // Tüm kolonilerin popülasyonunu ve yemek stoğunu güncelle
		            for (Koloni koloni : KoloniListesi) {
		                int pop = koloni.getPopulasyon();
		                int yeniPop = (int) (pop * 1.2); // Popülasyonu %20 artır
		                int yeniYemekStogu = koloni.getYemekStogu() - (yeniPop * 2); // Yemek stoğunu güncelle
		                
		                if (yeniYemekStogu <= 0) {
		                    yeniYemekStogu = 0; 
		                    // Yemek stoğu negatif olmaması için sıfıra düşürülür
		                }
		                
		                koloni.setYemekStogu(yeniYemekStogu);
		                koloni.setPopulasyon(yeniPop);
		                if (KoloniListesi.size() <= 1) break;

		            } 
		            	//Savasın gerceklesmesi
		            	for(int i=0; i<KoloniListesi.size(); i++) {
		            		koloni1 = KoloniListesi.get(i);
		            		for(int j=i+1; j<KoloniListesi.size(); j++) {
		            			koloni2 = KoloniListesi.get(j);
		            			taktik=new ATaktik();
		            			int savasSonucu = koloni2.Savas(taktik)-koloni1.Savas(taktik);
		            			if(savasSonucu > 0) { //koloni2 kazanırsa
		            				int azalma = (koloni1.getPopulasyon() * 10) / 100;
		            				int transfer = (koloni1.getYemekStogu() * 10) / 100;
		            				koloni1.setPopulasyon(koloni1.getPopulasyon()-azalma);
		            				koloni1.setYemekStogu(koloni1.getYemekStogu()-transfer);
		            				koloni2.setYemekStogu(koloni2.getYemekStogu()+transfer);
		            				koloni2.setKazanma();
		            				koloni1.setKaybetme();
		            			}
		            			else if(savasSonucu < 0) { //koloni1 kazanırsa
		            				int azalma = (koloni2.getPopulasyon() * 10) / 100;
		            				int transfer = (koloni2.getYemekStogu() * 10) / 100;
		            				koloni2.setPopulasyon(koloni2.getPopulasyon()-azalma);
		            				koloni2.setYemekStogu(koloni2.getYemekStogu()-transfer);
		            				koloni1.setYemekStogu(koloni1.getYemekStogu()+transfer);
		            				koloni1.setKazanma();
		            				koloni2.setKaybetme();
		            				
		            			}
		            			else { //TaktikSavas fonksiyonlarından aynı değer dönerse
		            				if(koloni2.getPopulasyon() > koloni1.getPopulasyon()) { //koloni2 kazanırsa
		            					int azalma = (koloni1.getPopulasyon() * 10) / 100;
			            				int transfer = (koloni1.getYemekStogu() * 10) / 100;
			            				koloni1.setPopulasyon(koloni1.getPopulasyon()-azalma);
			            				koloni1.setYemekStogu(koloni1.getYemekStogu()-transfer);
			            				koloni2.setYemekStogu(koloni2.getYemekStogu()+transfer);
			            				koloni2.setKazanma();
			            				koloni1.setKaybetme();
			            			    }
		            				else if(koloni1.getPopulasyon() > koloni2.getPopulasyon()) { //koloni1 kazanırsa
		            					int azalma = (koloni2.getPopulasyon() * 10) / 100;
			            				int transfer = (koloni2.getYemekStogu() * 10) / 100;
			            				koloni2.setPopulasyon(koloni2.getPopulasyon()-azalma);
			            				koloni2.setYemekStogu(koloni2.getYemekStogu()-transfer);
			            				koloni1.setYemekStogu(koloni1.getYemekStogu()+transfer);
			            				koloni1.setKazanma();
			            				koloni2.setKaybetme();
		            				}
		            				else {//popülasyonlar da eşitse
		            					Random randomNumber=new Random();
		            					int random=randomNumber.nextInt(2);
		            					if(random==0) {//koloni1 kazanması durumu
		            						int azalma = (koloni2.getPopulasyon() * 10) / 100;
				            				int transfer = (koloni2.getYemekStogu() * 10) / 100;
				            				koloni2.setPopulasyon(koloni2.getPopulasyon()-azalma);
				            				koloni2.setYemekStogu(koloni2.getYemekStogu()-transfer);
				            				koloni1.setYemekStogu(koloni1.getYemekStogu()+transfer);
				            				koloni1.setKazanma();
				            				koloni2.setKaybetme();
		            					}
		            					else {  //koloni2 kazanması durumu
		            						int azalma = (koloni1.getPopulasyon() * 10) / 100;
				            				int transfer = (koloni1.getYemekStogu() * 10) / 100;
				            				koloni1.setPopulasyon(koloni1.getPopulasyon()-azalma);
				            				koloni1.setYemekStogu(koloni1.getYemekStogu()-transfer);
				            				koloni2.setYemekStogu(koloni2.getYemekStogu()+transfer);
				            				koloni2.setKazanma();
				            				koloni1.setKaybetme();
		            					}
		            				}
		            					
		            					
		            			}
		                        // Yemek stoğu veya popülasyon sıfıra veya eksiye düşen koloniyi sil
		            			if(koloni1.getPopulasyon()<=0 || koloni1.getYemekStogu()<=0) {
		            				KoloniListesi.remove(koloni1);
		            				koloni1.tukendi(tukenenKoloniler);
		            				i--; // KoloniListesi boyutu değiştiğinde indeks düzenlemesi yapılır
		                            break;
		            			
		            			}
		            			if(koloni2.getPopulasyon()<=0 || koloni2.getYemekStogu()<=0) {
		            				KoloniListesi.remove(koloni2);
		            				koloni2.tukendi(tukenenKoloniler);
		            				j--;
		            				
		            			}       
		            			
		            		}
		            		
		            		if (KoloniListesi.size() < 2) {
		                        devam = false;
		                        break; // Döngüden çık
		                    }
		            	}
			            
		            	Iterator<Koloni> iterator = KoloniListesi.iterator();
		            	while (iterator.hasNext()) {
		            	    Koloni koloni = iterator.next();
		            	    if (koloni.getPopulasyon() <= 0 || koloni.getYemekStogu() <= 0 || koloni.getPopulasyon()==1 ) {
		            	        iterator.remove();
		            	        koloni.tukendi(tukenenKoloniler);
		            	    }
		            	}
		            turSayisi++;
		           		            
		            System.out.println(toString());
		        }
		        
		        
		        
		 }
		 
		 
		 public String toString() {
			    StringBuilder sb = new StringBuilder();
			    sb.append("--------------------------------------------------------------------\n");
			    sb.append("Tur Sayisi: ").append(turSayisi).append("\n");
			    sb.append("Koloni\t    Populasyon\t   Yemek Stogu\t     Kazanma\t    Kaybetme\n");

			    for (Koloni koloni : KoloniListesi) {
			        sb.append(koloni.getSembol()).append("\t\t")
			            .append(koloni.getPopulasyonAsString()).append("\t\t")
			            .append(koloni.getYemekStoguAsString()).append("\t\t")
			            .append(koloni.getKazanmaAsString()).append("\t\t")
			            .append(koloni.getKaybetmeAsString()).append("\n");
			    }

			    // Tukenen kolonileri ekle
			    for (Koloni tukenenKoloni : tukenenKoloniler) {
			        sb.append(tukenenKoloni.getSembol()).append("\t\t")
			            .append("--").append("\t\t")
			            .append("--").append("\t\t")
			            .append("--").append("\t\t")
			            .append("--").append("\n");
			    }

			    sb.append("--------------------------------------------------------------------\n");
			    return sb.toString();
			}
		} 
		 
