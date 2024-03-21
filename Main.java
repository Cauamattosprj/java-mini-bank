package banksystem;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main {    public static void main(String[] args) {
        Scanner readInput = new Scanner(System.in, Charset.forName("UTF-8"));

        try {
            // localização do arquivo.
            String arquivo = "user.home";

            System.out.println("Bem-vindo(a) ao Banco Elitista!");

            // Captura dos dados dos clientes.
            System.out.println("Digite seu nome completo: ");
            String nome = readInput.nextLine();
            System.out.println(nome);

            System.out.println("Digite seu CPF (apenas números): ");
            String cpf = readInput.nextLine();

            System.out.println("Digite sua senha: ");
            String senha = readInput.nextLine();

            System.out.println("Digite o dia do seu nascimento: ");
            String diaNascimento = readInput.nextLine();

            System.out.println("Digite o mês do seu nascimento: ");
            String mesNascimento = readInput.nextLine();

            System.out.println("Digite o ano do seu nascimento: ");
            String anoNascimento = readInput.nextLine();

            System.out.println("Digite seu estado de residência.\nOpções: RJ, SP ");
            String estado = readInput.nextLine();

            System.out.println("Digite seu CEP: ");
            String cep = readInput.nextLine();

            System.out.println("Qual a sua profissão?\nOpções:\n(1) Filho do dono\n(2) Militar das Forças Armadas\n(3) Herdeiro\n(4) Médico\n(5) Rayanne Maria\n(6) CAAAAVEIRAAAA");
            String profissao = readInput.nextLine();

            System.out.println("Digite a média dos seus 3 últimos contracheques: ");
            String salario = readInput.nextLine();

            System.out.println("Digite o número do seu celular (apenas números): ");
            String telefone = readInput.nextLine();

            System.out.println("Digite o seu e-mail: ");
            String email = readInput.nextLine();

            // Configuração inicial do DocumentBuilder W3.
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder dc = dbf.newDocumentBuilder();
            Document d = dc.newDocument();

            // elemento raiz do xml
            Element raiz = d.createElement("cadastros");
            d.appendChild(raiz);

            Element cliente = d.createElement("cliente");
            raiz.appendChild(cliente);

            // definindo atributo do post
            Attr attr = d.createAttribute("conta");
            long currentTimeStamp = System.currentTimeMillis();
            attr.setValue("_" + currentTimeStamp);
            cliente.setAttributeNode(attr);

            // definindo os dados do cliente na tag

            Element nomeCliente = d.createElement("nome");
            nomeCliente.appendChild(d.createTextNode(nome.toUpperCase()));
            cliente.appendChild(nomeCliente);

            Element senhaCliente = d.createElement("senha");
            senhaCliente.appendChild(d.createTextNode(senha));
            cliente.appendChild(senhaCliente);

            Element diaNascCliente = d.createElement("diaNascimento");
            diaNascCliente.appendChild(d.createTextNode(diaNascimento));
            cliente.appendChild(diaNascCliente);

            Element mesNascCliente = d.createElement("mesNascimento");
            mesNascCliente.appendChild(d.createTextNode(mesNascimento));
            cliente.appendChild(mesNascCliente);

            Element anoNascCliente = d.createElement("anoNascimento");
            anoNascCliente.appendChild(d.createTextNode(anoNascimento));
            cliente.appendChild(anoNascCliente);
            
            Element estadoCliente = d.createElement("estado");
            estadoCliente.appendChild(d.createTextNode(estado));
            cliente.appendChild(estadoCliente);

            Element cepCliente = d.createElement("cep");
            cepCliente.appendChild(d.createTextNode(cep));
            cliente.appendChild(cepCliente);

            Element profissaoCliente = d.createElement("profissao");
            profissaoCliente.appendChild(d.createTextNode(profissao));
            cliente.appendChild(profissaoCliente);

            Element salarioCliente = d.createElement("salario");
            salarioCliente.appendChild(d.createTextNode(salario));
            cliente.appendChild(salarioCliente);

            Element telefoneCliente = d.createElement("telefone");
            telefoneCliente.appendChild(d.createTextNode(telefone));
            cliente.appendChild(telefoneCliente);

            Element emailCliente = d.createElement("email");
            emailCliente.appendChild(d.createTextNode(email));
            cliente.appendChild(emailCliente);


            // Construção do XML
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            DOMSource domSource = new DOMSource(d);
            StreamResult streamResult = new StreamResult(new File(arquivo));

            // juntar conteúdo ao arquivo criado
            t.transform(domSource, streamResult);
            System.out.println("Arquivo criado com êxito.");


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Diretório: " + System.getProperty("user.dir"));
        }
    }
}

