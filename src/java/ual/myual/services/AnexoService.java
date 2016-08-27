/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.services;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ual.myual.datamanager.AnexoDAO;
import ual.myual.models.*;

/**
 *
 * @author Diogo
 */
@Service
public class AnexoService {
    
    @Autowired
    private AnexoDAO anexoDAO;

    public AnexoService() {
    }
    
    /*funçao que retorna as cadeiras disponiveis para preencher anexo*/
    public ArrayList<UnidadeCurricular> getCadeiras()
    {
        ArrayList<UnidadeCurricular> cadeiras = anexoDAO.getCadeiras();
        
        return cadeiras;
        
    }
    
    /*funçao que retorna um anexo novo so as perguntas, por preencher as respostas*/
    public AnexoForm newAnexo(){
    
        AnexoB anexo = anexoDAO.getnewAnexo();
        
        AnexoForm anexoForm = new AnexoForm(anexo.getAnexo());
        
        return anexoForm;
        
    }
    
    /*funçao que retorna um anexo com o respectivo id*/
    public AnexoForm getAnexo(int anexoId){
    
    
        AnexoB anexo = anexoDAO.getAnexo(anexoId);
        
        AnexoForm anexoForm = new AnexoForm(anexo.getAnexo());
        
        return anexoForm;
        
    }
    
    /*funçao que retorna todos os anexos e os detalhes*/
    public ArrayList<AnexoForm> getAllAnexos(User user){
    
    
        ArrayList<AnexoForm> anexo = anexoDAO.getAllAnexos(user.getId());
        
        for(AnexoForm a : anexo)
        {
            a.setProfessor(user);
        }
        return anexo;
        
    }
    
    /*funçao que faz o update do campo estado do anexo pedido para ficar a d - deleted*/
    public void setEstadoDeleted(int anexoid)
    {
        anexoDAO.setEstadoDeleted(anexoid);
    }
    
    public AnexoForm getCopyAnexo(int anexoid)
    {
        AnexoB anexob = anexoDAO.getAnexo(anexoid);
        
        AnexoForm anexoForm = new AnexoForm(anexob.getAnexo(),anexob.getPergunta10());
        
        return anexoForm;
    }
    
    
    public ByteArrayOutputStream generatePDF(int id){
    
        
        try {
            
            AnexoB anexo = anexoDAO.getAnexo(id);
            
            Document document = new Document(PageSize.A4);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter writer = PdfWriter.getInstance(document, baos);
            
            document.open();
            
            PdfPTable table = new PdfPTable(2);
            table.setWidths(new int[]{ 10, 10});
            
            PdfPCell cell;
            cell = new PdfPCell(new Phrase("Pergunta"));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Resposta"));
            table.addCell(cell);
            
            document.add(table);
            
            for(Pergunta p : anexo.getAnexo()){
            
                if(p.getNr_pergunta().equalsIgnoreCase("10")){
                
                    PdfPTable table2 = new PdfPTable(1);
                    table2.setWidths(new int[]{ 20});
                    table2.addCell(p.getNr_pergunta()+" - "+p.getPergunta());
                    document.add(table2);
                    
                    
                    PdfPTable table3 = new PdfPTable(7);

                    table3.setWidths(new int[]{ 5,5,10,2,2,2,10});
                    cell = new PdfPCell(new Phrase("Semana Nº"));
                    cell.setRowspan(2);
                    table3.addCell(cell);
                    cell = new PdfPCell(new Phrase("Sessão Nº"));
                    cell.setRowspan(2);
                    table3.addCell(cell);
                    cell = new PdfPCell(new Phrase("Conteúdo Programático"));
                    cell.setRowspan(2);
                    table3.addCell(cell);
                    cell = new PdfPCell(new Phrase("Horas de trabalho"));
                    cell.setColspan(3);
                    table3.addCell(cell);
                    cell = new PdfPCell(new Phrase("Descrição de outras actividades"));
                    cell.setRowspan(2);
                    table3.addCell(cell);
                    cell = new PdfPCell(new Phrase("Contacto"));
                    table3.addCell(cell);
                    cell = new PdfPCell(new Phrase("Consolidação"));
                    table3.addCell(cell);
                    cell = new PdfPCell(new Phrase("Outras Actividades"));
                    table3.addCell(cell);
                    
                    int j=0;
                    for(int i : anexo.getPergunta10().getNr_semana()){
                    
                        cell = new PdfPCell(new Phrase(Integer.toString(i)));
                        table3.addCell(cell);
                        cell = new PdfPCell(new Phrase(Integer.toString(anexo.getPergunta10().getNr_sessao().get(j))));
                        table3.addCell(cell);
                        cell = new PdfPCell(new Phrase(anexo.getPergunta10().getConteudo_programatico().get(j)));
                        table3.addCell(cell);
                        cell = new PdfPCell(new Phrase(Integer.toString(anexo.getPergunta10().getHoras_de_trabalho().get(j).getHoras_contacto())));
                        table3.addCell(cell);
                        cell = new PdfPCell(new Phrase(Integer.toString(anexo.getPergunta10().getHoras_de_trabalho().get(j).getHoras_consolidacao())));
                        table3.addCell(cell);
                        cell = new PdfPCell(new Phrase(Integer.toString(anexo.getPergunta10().getHoras_de_trabalho().get(j).getHoras_outras_actividades())));
                        table3.addCell(cell);
                        cell = new PdfPCell(new Phrase(anexo.getPergunta10().getDescricao_outras_actividades().get(j)));
                        table3.addCell(cell);
                    
                        j++;
                    }
                
                    document.add(table3);
                }
                else{
                    PdfPTable table1 = new PdfPTable(2);
                    table1.setWidths(new int[]{ 10, 10});
                    table1.addCell(p.getNr_pergunta()+" - "+p.getPergunta());
                    table1.addCell(p.getResposta());
                    document.add(table1);
                }
            
            
            }
            
            document.close();
            writer.close();
            
            return baos;
        } catch (DocumentException ex) {
            Logger.getLogger(AnexoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int saveAnexo(User user, AnexoForm anexo)
    {
        AnexoB anexob = new AnexoB();
        
        anexob.setPergunta10(anexo.getPergunta10());
        anexob.setAnexo(anexo.getAnexo());
        
        int id = anexoDAO.saveAnexo(user, anexob);
        
        return id;
        
    }
    
    public void sendEmail(ByteArrayOutputStream baos){
    
        Email email = anexoDAO.getEmail();
        
        final String username = email.getEmail();
        final String password = email.getPassword();

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                }
          });

        try {
            
            //construct the text body part
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("Bom dia,"
                    + "\n\n Segue em anexo um anexo B, que foi criado agora mesmo.");
            
            byte[] bytes = baos.toByteArray();
            
            //construct the pdf body part
            DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
            MimeBodyPart pdfBodyPart = new MimeBodyPart();
            pdfBodyPart.setDataHandler(new DataHandler(dataSource));
            pdfBodyPart.setFileName("anexo.pdf");
            
            
            //construct the mime multi part
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart);
            
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.addRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("dio.be@hotmail.com"));
            /*message.addRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("patrecaas@gmail.com"));
            message.addRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("sandra.abreu@gmail.com"));*/
            message.setSubject("MyUal");
            message.setContent(mimeMultipart);
            

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
                throw new RuntimeException(e);
        }
        finally {
            //clean off
            if(null != baos) {
                try { baos.close(); baos = null; }
                catch(Exception ex) { }
            }
        }
    }
    
    public boolean validatePergunta10(AnexoForm anexoForm)
    {
        if(!anexoForm.getPergunta10().getNr_semana().isEmpty())
        {
            int i;
            for(int x=0; x<anexoForm.getPergunta10().getNr_semana().size();x++)
            {
                try{
                    
                    i = (int) anexoForm.getPergunta10().getNr_semana().get(x);
                    i = (int) anexoForm.getPergunta10().getNr_sessao().get(x);
                    i = (int) anexoForm.getPergunta10().getHoras_de_trabalho().get(x).getHoras_contacto();
                    i = (int) anexoForm.getPergunta10().getHoras_de_trabalho().get(x).getHoras_contacto();
                    i = (int) anexoForm.getPergunta10().getHoras_de_trabalho().get(x).getHoras_outras_actividades();
                }
                catch(Exception e)
                {
                    return false;
                }
                
            }
            return true;
        }
        else 
            return true;
    }
}
