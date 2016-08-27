/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
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
import ual.myual.datamanager.CVDAO;
import ual.myual.exceptions.CustomGenericException;
import ual.myual.models.AnexoB;
import ual.myual.models.CV;
import ual.myual.models.Email;
import ual.myual.models.Pergunta;
import ual.myual.models.User;
import ual.myual.models.jsp.CVForm;

/**
 *
 * @author Diogo
 */
@Service
public class CVService {
    
    @Autowired
    private CVDAO cvDAO;

    public CVService() {
    }
    
    public CVForm getCV(User user)
    {
        int nr_cvs= cvDAO.haveCV(user.getId());
        
        if(nr_cvs==0)
        {
            CV cv = cvDAO.getnewCV();
        
            CVForm cvForm = new CVForm(cv.getQuestionario());
        
            return cvForm;
        }
        if(nr_cvs==1)
        {
            CV cv = cvDAO.getUserCV(user.getId());
            
            CVForm cvForm = new CVForm(cv.getQuestionario());
            
            return cvForm;

        }
        else
            throw new CustomGenericException("E888", "Error CVService getCV");
    }
    
    public void savecv(CVForm cvForm, User user)
    {
        int nr_cvs= cvDAO.haveCV(user.getId());
        
        if(nr_cvs==0)
        {
            CV cv = new CV();
            
            cv.setQuestionario(cvForm.getQuestionario());
            
            cvDAO.saveNewcv(cv, user);
        }
        if(nr_cvs==1)
        {
            CV cv = new CV();
            
            cv.setQuestionario(cvForm.getQuestionario());
            
            cvDAO.editCv(cv);
            
        }
        else
            throw new CustomGenericException("E888", "Error CVService saveCV");
            
    }
    
    public ByteArrayOutputStream generatePDF(int id){
    
        try {
            
            CV cv = cvDAO.getUserCV(id);
            
            Document document = new Document(PageSize.A4);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter writer = PdfWriter.getInstance(document, baos);
            
            document.open();
            
            PdfPTable table = new PdfPTable(2);
            table.setWidths(new int[]{ 10, 10});
            
            PdfPCell cell;
            
            
            for(Pergunta p : cv.getQuestionario()){
            
                cell = new PdfPCell(new Phrase(p.getNr_pergunta() +" - "+p.getPergunta()));
                table.addCell(cell);
                cell = new PdfPCell(new Phrase(p.getResposta()));
                table.addCell(cell);
            
            
            }
            
            document.add(table);
            document.close();
            writer.close();
            
            return baos;
        } catch (DocumentException ex) {
            Logger.getLogger(AnexoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void sendEmail(ByteArrayOutputStream baos){
    
        Email email = cvDAO.getEmail();
        
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
                    + "\n\n Segue em anexo um CV actualizado.");
            
            byte[] bytes = baos.toByteArray();
            
            //construct the pdf body part
            DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
            MimeBodyPart pdfBodyPart = new MimeBodyPart();
            pdfBodyPart.setDataHandler(new DataHandler(dataSource));
            pdfBodyPart.setFileName("cv.pdf");
            
            
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
    
    
}
