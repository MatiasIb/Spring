package web.de.reclamos.grupo4.email;

public class EmailBody{
        private String email;
        private String content = "Bienvenido a nuestra pagina web";
        private String subject = "Bienvenida";

        public String getEmail() {
            return email;
        }

        public EmailBody setEmail(String email) {
            this.email = email;
            return null;
        }

        public String getContent() {
            return content;
        }

        public EmailBody setContent(String content) {
            this.content = content;
            return null;
        }

        public String getSubject() {
            return subject;
        }

        public EmailBody setSubject(String subject) {
            this.subject = subject;
            return null;
        }

        @Override
        public String toString() {
            return "EmailBody [email=" + email + ", content=" + content + ", subject=" + subject + "]";
        }


    }

