import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.io.*;
import java.lang.Integer;
import java.lang.Double;

public class ConexiuneBD {
	private String url = "jdbc:mysql://localhost:3306/universitate";
	private String uid = "root";
	private String pw = "bazededate2020";
	private BufferedReader reader;
	public static Connection con;

	public static void main(String[] args) {
		ConexiuneBD app = new ConexiuneBD();
		app.init();
		// app.run();
	}

	public void init() {
		// Initialize your application
		// Register the MySQL driver and make a connection
		try { // Load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.println("ClassNotFoundException: " + e);
		}

		con = null;
		try {
			con = DriverManager.getConnection(url, uid, pw);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex);
			System.exit(1);
		}

		// Set up console reader
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	private void closeConnection() {
		try {
			con.close();
		} catch (SQLException ex) {
			System.err.println("Exception during connection close: " + ex);
		}
	}

	public String cautareCurs(String nume) {

		String mesajEroare = new String();

		String query = "{ call cautareCurs(?,?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setString(1, nume);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);

			rs = stmt.executeQuery();

			mesajEroare = stmt.getString(2);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return mesajEroare;
	}
	
	public ArrayList<String> autentificare(String email, String parola) {
		ArrayList<String> result = new ArrayList<String>();

		String mesajEroare = new String();

		String query = "{ call autentificare(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setString(1, email);
			stmt.setString(2, parola);
			stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(5, java.sql.Types.CHAR);
			stmt.registerOutParameter(6, java.sql.Types.CHAR);
			stmt.registerOutParameter(7, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(8, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(9, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(10, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(11, java.sql.Types.INTEGER);
			stmt.registerOutParameter(12, java.sql.Types.VARCHAR);

			rs = stmt.executeQuery();

			mesajEroare = stmt.getString(12);

			if (mesajEroare != null) {
				result.add(mesajEroare);
			} else {
				result.add(stmt.getString(3));
				result.add(stmt.getString(4));
				result.add(stmt.getString(5));
				result.add(stmt.getString(6));
				result.add(stmt.getString(7));
				result.add(stmt.getString(8));
				result.add(stmt.getString(9));
				result.add(stmt.getString(10));
				result.add(stmt.getString(11));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return result;
	}

	public String contNou(String email, String parola, String confirmaParola) {

		String mesajEroare = new String();

		String query = "{ call creareCont(?, ?, ?, ?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setString(1, email);
			stmt.setString(2, parola);
			stmt.setString(3, confirmaParola);
			stmt.registerOutParameter(4, java.sql.Types.VARCHAR);

			rs = stmt.executeQuery();

			mesajEroare = stmt.getString(4);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return mesajEroare;
	}

	public String getNumeGrup(int idGrup) {
		String numeGrup = new String();
		String query = "{ call getNumeGrup(?, ?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setInt(1, idGrup);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);

			rs = stmt.executeQuery();

			numeGrup = stmt.getString(2);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return numeGrup;
	}

	public void afisareMembri(int idGrup) {
		String query = "{ call afisareMembri(?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setInt(1, idGrup);

			rs = stmt.executeQuery();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void afisareStudenti(int idActivitate) {
		String query = "{ call afisareStudenti(?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setInt(1, idActivitate);

			rs = stmt.executeQuery();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void afisareMesaje(int idGrup) {
		String query = "{ call afisareMesaje(?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setInt(1, idGrup);

			rs = stmt.executeQuery();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public String adaugareMaterie(String numeMaterie, String descriere) {
		String mesajEroare = new String();

		String query = "{ call adaugareMaterie(?, ?, ?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setString(1, numeMaterie);
			stmt.setString(2, descriere);
			stmt.registerOutParameter(3, java.sql.Types.VARCHAR);

			rs = stmt.executeQuery();

			mesajEroare = stmt.getString(3);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return mesajEroare;
	}

	public ArrayList<String> getNumeStudent(int idStudent) {

		ArrayList<String> result = new ArrayList<String>();

		String query = "{ call getNumeStudent(?, ?, ?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setInt(1, idStudent);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			rs = stmt.executeQuery();

			result.add(stmt.getString(2));
			result.add(stmt.getString(3));

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return result;
	}

	public void trimitereMesaj(String msj, int idUser, int idGr) {

		String query = "{ call trimitereMesaj(?, ?, ?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setString(1, msj);
			stmt.setInt(2, idUser);
			stmt.setInt(3, idGr);

			rs = stmt.executeQuery();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void sugestiiParticipanti(int idGrup) {

		String query = "{ call sugestiiParticipanti(?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setInt(1, idGrup);

			rs = stmt.executeQuery();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void cautareUtilizator(String nume, String prenume, String tip) {
        String query = "{ call cautareUtilizator(?, ?, ?) }";
        ResultSet rs;
        try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1, nume);
            stmt.setString(2, prenume);
            stmt.setString(3, tip);
           
            rs = stmt.executeQuery();
           
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }
	
	public String modificareDate(String emailUser, String newNume, String newPrenume, String newCnp, String newTelefon, String newAdresa, String newIban, String newNrContract) {
        String mesajEroare = new String();
        String query = "{ call modificareDate(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        ResultSet rs;
       
        try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1, emailUser);
            stmt.setString(2, newNume);
            stmt.setString(3, newPrenume);
            stmt.setString(4, newCnp);
            stmt.setString(5, newTelefon);
            stmt.setString(6, newAdresa);
            stmt.setString(7,  newIban);
            stmt.setString(8, newNrContract);
            stmt.registerOutParameter(9, java.sql.Types.VARCHAR);
           
            rs = stmt.executeQuery();
           
            mesajEroare = stmt.getString(9);
           
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mesajEroare;
       
    }
	
	public void toateGrupurile() {
        String query = "{ call toateGrupurile() }";
        ResultSet rs;
        try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
            rs = stmt.executeQuery();
           
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }
	
	public String inscriereGrup(int idStudent, int idGrup) {
		String mesajEroare = new String();

		String query = "{ call inscriereGrup(?, ?, ?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setInt(1, idStudent);
			stmt.setInt(2, idGrup);
			stmt.registerOutParameter(3, java.sql.Types.VARCHAR);

			rs = stmt.executeQuery();

			mesajEroare = stmt.getString(3);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return mesajEroare;
	}
	
	public String getNumeMaterie(int idMaterie) {
		String numeMaterie = new String();
		String query = "{ call getNumeMaterie(?, ?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setInt(1, idMaterie);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);

			rs = stmt.executeQuery();

			numeMaterie = stmt.getString(2);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return numeMaterie;
	}
	
	public void toateCursurileStudentului(int idStudent) {
		String query = "{ call toateCursurileStudentului(?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setInt(1, idStudent);

			rs = stmt.executeQuery();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void creareGrup(int idMaterie, String numeGrup) {
        String query = "{ call creareGrup(?, ?) }";
        ResultSet rs;
        try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
        	
        	stmt.setInt(1, idMaterie);
        	stmt.setString(2, numeGrup);
        	
            rs = stmt.executeQuery();
           
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }
	
	public void totiProfesorii() {
		String query = "{ call totiProfesorii() }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			rs = stmt.executeQuery();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public ArrayList <String> creareActivitate(int idGrup, Date dataDesfasurare, Time ora, float durata, float timpExpirare, int minStudenti) {
        ArrayList<String> result = new ArrayList<String>();
        String query = "{ call creareActivitate(?, ?, ?, ?, ?, ?, ?, ?) }";
        ResultSet rs;
       
        try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, idGrup);
            stmt.setDate(2, dataDesfasurare);
            stmt.setTime(3, ora);
            stmt.setFloat(4, durata);
            stmt.setFloat(5, timpExpirare);
            stmt.setInt(6, minStudenti);
            stmt.registerOutParameter(7, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(8, java.sql.Types.INTEGER);
            rs = stmt.executeQuery();
           
            result.add(stmt.getString(7));
            result.add(String.valueOf(stmt.getInt(8)));
           
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
       
    }
	
	public void invitaProfesor(int idActivitate, int idProfesor) {
		String query = "{ call invitaProfesor(?, ?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
			stmt.setInt(1, idActivitate);
			stmt.setInt(2, idProfesor);
			rs = stmt.executeQuery();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void toateActivitatileCuProfesor() {
		String query = "{ call toateActivitatileCuProfesor() }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			rs = stmt.executeQuery();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void toateActivitatileFaraProfesor() {
		String query = "{ call toateActivitatileFaraProfesor() }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			rs = stmt.executeQuery();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public String inscriereActivitateGrup(int idStudent, int idActivitate) {
		String mesajEroare = new String();

		String query = "{ call inscriereActivitateGrup(?, ?, ?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setInt(1, idStudent);
			stmt.setInt(2, idActivitate);
			stmt.registerOutParameter(3, java.sql.Types.VARCHAR);

			rs = stmt.executeQuery();

			mesajEroare = stmt.getString(3);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return mesajEroare;
	}
	
	public void toateGrupurileStudentului(int idStudent) {
		String query = "{ call toateGrupurileStudentului(?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setInt(1, idStudent);

			rs = stmt.executeQuery();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void toateMateriileProfesorului(int idProf) {
		String query = "{ call toateMateriileProfesorului(?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setInt(1, idProf);

			rs = stmt.executeQuery();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public String vizualizareNoteCurs(int idProf, int idMaterie) {
		String mesajEroare = new String();

		String query = "{ call vizualizareNoteCurs(?, ?, ?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setInt(1, idProf);
			stmt.setInt(2, idMaterie);
			stmt.registerOutParameter(3, java.sql.Types.VARCHAR);

			rs = stmt.executeQuery();

			mesajEroare = stmt.getString(3);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return mesajEroare;
	}
	
	public String vizualizareNoteLaborator(int idProf, int idMaterie) {
		String mesajEroare = new String();

		String query = "{ call vizualizareNoteLaborator(?, ?, ?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setInt(1, idProf);
			stmt.setInt(2, idMaterie);
			stmt.registerOutParameter(3, java.sql.Types.VARCHAR);

			rs = stmt.executeQuery();

			mesajEroare = stmt.getString(3);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return mesajEroare;
	}
	
	public String vizualizareNoteSeminar(int idProf, int idMaterie) {
		String mesajEroare = new String();

		String query = "{ call vizualizareNoteSeminar(?, ?, ?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setInt(1, idProf);
			stmt.setInt(2, idMaterie);
			stmt.registerOutParameter(3, java.sql.Types.VARCHAR);

			rs = stmt.executeQuery();

			mesajEroare = stmt.getString(3);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return mesajEroare;
	}
	
	public String vizualizareNoteMaterie(int idProf) {
		String mesajEroare = new String();

		String query = "{ call vizualizareNoteMaterie(?, ?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setInt(1, idProf);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);

			rs = stmt.executeQuery();

			mesajEroare = stmt.getString(2);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return mesajEroare;
	}
	
	public String vizualizareNoteStudent(int idStudent) {
		String mesajEroare = new String();

		String query = "{ call vizualizareNoteStudent(?, ?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setInt(1, idStudent);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);

			rs = stmt.executeQuery();

			mesajEroare = stmt.getString(2);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return mesajEroare;
	}
	
	public String incarcareProcentuala(int idMaterie, int idProfCurs, int procentCurs, int procentLab, int procentSeminar) {
        String mesajEroare = new String();
        String query = "{ call incarcareProcentuala(?, ?, ?, ?, ?, ?) }";
        ResultSet rs;
       
        try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, idMaterie);
            stmt.setInt(2, idProfCurs);
            stmt.setInt(3, procentCurs);
            stmt.setInt(4, procentLab);
            stmt.setInt(5, procentSeminar);
            stmt.registerOutParameter(6, java.sql.Types.INTEGER);
            rs = stmt.executeQuery();
           
            mesajEroare = stmt.getString(6);
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mesajEroare;       
    }
	
	public int gasireActivitate(String numeMaterie, String numeProfesor, String prenumeProfesor) {
		
        int idActivitate = 0;
        String query = "{ call gasireActivitate(?, ?, ?, ?) }";
        ResultSet rs;
       
        try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1, numeMaterie);
            stmt.setString(2, numeProfesor);
            stmt.setString(3, prenumeProfesor);
            stmt.registerOutParameter(4, java.sql.Types.INTEGER);
            rs = stmt.executeQuery();
           
            idActivitate = stmt.getInt(4);
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return idActivitate;       
    }
	
	public String anStudiu(String email, int an, int ore) {
		String mesajEroare = new String();
		String query = "{ call adaugareDetaliiStudent(?, ?, ?, ?) }";
		ResultSet rs;
		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
			stmt.setString(1, email);
			stmt.setInt(2, an);
			stmt.setInt(3, ore);
			rs = stmt.executeQuery();
			mesajEroare = stmt.getString(4);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return mesajEroare;
	}
	
	public ArrayList<Integer> getInfoStudent(String email){
		ArrayList<Integer> myList = new ArrayList<Integer>();
		String query = "{ call getInfoStudent(?, ?, ?) }";
		ResultSet rs;
		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
			stmt.setString(1, email);
			stmt.registerOutParameter(2, java.sql.Types.INTEGER);
			stmt.registerOutParameter(3, java.sql.Types.INTEGER);
			rs = stmt.executeQuery();
			Integer anS = new Integer(stmt.getInt(2));
			Integer ore = new Integer(stmt.getInt(3));
			myList.add(anS);
			myList.add(ore);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return myList;
	}
	
	public ArrayList<Integer> getInfoProfesor(String email){
		ArrayList<Integer> myList = new ArrayList<Integer>();
		String query = "{ call getInfoProfesor(?, ?, ?, ?) }";
		ResultSet rs;
		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
			stmt.setString(1, email);
			stmt.registerOutParameter(2, java.sql.Types.INTEGER);
			stmt.registerOutParameter(3, java.sql.Types.INTEGER);
			stmt.registerOutParameter(4, java.sql.Types.INTEGER);
			rs = stmt.executeQuery();
			myList.add(stmt.getInt(2));
			myList.add(stmt.getInt(3));
			myList.add(stmt.getInt(4));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return myList;
	}
	
	public String getNumeDep(int id) {
		String nume = new String();
		String query = "{ call getNumeDep(?, ?) }";
		ResultSet rs;
		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
			stmt.setInt(1, id);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			rs = stmt.executeQuery();
			nume = stmt.getString(2);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return nume;
	}
	
	public String adaugareDetaliiProfesor(String email, int nrMin, int nrMax, String dep) {
		String mesajEroare = new String();
		String query = "{ call adaugareDetaliiProfesor(?, ?, ?, ?, ?) }";
		ResultSet rs;
		
		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
			stmt.setString(1, email);
			stmt.setInt(2, nrMin);
			stmt.setInt(3, nrMax);
			stmt.setString(4, dep);
			stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
			
			rs = stmt.executeQuery();
			
			mesajEroare = stmt.getString(5);
			
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return mesajEroare;
	}
	
	public String stergereInformatii(String email) {
		String mesajEroare = new String();
		String query = "{ call stergereInformatii(?, ?) }";
		ResultSet rs;
		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
			stmt.setString(1, email);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			rs = stmt.executeQuery();
			mesajEroare = stmt.getString(2);
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return mesajEroare;
	}
	
	public ArrayList<String> getDate(String emailUser){
		ArrayList<String> myList = new ArrayList<String>();
		String query = "{ call getDate(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
		ResultSet rs;
		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
			stmt.setString(1, emailUser);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(6, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(7, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(8, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(9, java.sql.Types.VARCHAR);
			
			rs = stmt.executeQuery();
			
			myList.add(stmt.getString(2));
			myList.add(stmt.getString(3));
			myList.add(stmt.getString(4));
			myList.add(stmt.getString(5));
			myList.add(stmt.getString(6));
			myList.add(stmt.getString(7));
			myList.add(stmt.getString(8));
			myList.add(stmt.getString(9));
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return myList;
	}
	
	public int getTipUser(String email) {
		int tip = -1;
		String query = "{ call getTipUser(?, ?) }";
		ResultSet rs;
		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
			stmt.setString(1, email);
			stmt.registerOutParameter(2, java.sql.Types.INTEGER);
			rs = stmt.executeQuery();
			tip = stmt.getInt(2);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return tip;
	}
	
	public int getIdStudent(String email) {
		int idStudent = 0;
		String query = "{ call getIdStudent(?, ?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setString(1, email);
			stmt.registerOutParameter(2, java.sql.Types.INTEGER);

			rs = stmt.executeQuery();

			idStudent = stmt.getInt(2);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return idStudent;
	}
	
	public String getNrContract(String nume, String prenume) {
		String nr = new String();
		String query = "{ call getNrContract(?, ?, ?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setString(1, nume);
			stmt.setString(2, prenume);
			stmt.registerOutParameter(3, java.sql.Types.VARCHAR);

			rs = stmt.executeQuery();

			nr = stmt.getString(3);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return nr;
	}
	
	public int getIdMaterie(String nume) {
		int idMaterie = 0;
		String query = "{ call getIdMaterie(?, ?) }";
		ResultSet rs;

		try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {

			stmt.setString(1, nume);
			stmt.registerOutParameter(2, java.sql.Types.INTEGER);

			rs = stmt.executeQuery();

			idMaterie = stmt.getInt(2);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return idMaterie;
	}
	
	public String asignareProfCurs(String numeProf, String prenumeProf, String contractProf, String numeCurs, String tipAct) {
        String mesajEroare = new String();
        String query = "{ call asignareProfCurs(?, ?, ?, ?, ?, ?) }";
        ResultSet rs;
       
        try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1, numeProf);
            stmt.setString(2, prenumeProf);
            stmt.setString(3, contractProf);
            stmt.setString(4, numeCurs);
            stmt.setString(5, tipAct);
            stmt.registerOutParameter(6, java.sql.Types.VARCHAR);
           
            rs = stmt.executeQuery();
           
            mesajEroare = stmt.getString(6);
           
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mesajEroare;
    }
	
	public String inscriereCurs(int idStudent, int idMaterie) {
        String mesajEroare = new String();
        String query = "{ call inscriereCurs(?, ?, ?) }";
        ResultSet rs;
       
        try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, idStudent);
            stmt.setInt(2, idMaterie);
            stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
           
            rs = stmt.executeQuery();
           
            mesajEroare = stmt.getString(3);
           
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mesajEroare;
    }
	
	public String renuntareCurs(int idStudent, int idMaterie) {
        String mesajEroare = new String();
        String query = "{ call renuntareCurs(?, ?, ?) }";
        ResultSet rs;
       
        try (Connection conn = con; CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, idStudent);
            stmt.setInt(2, idMaterie);
            stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
           
            rs = stmt.executeQuery();
           
            mesajEroare = stmt.getString(3);
           
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mesajEroare;
    }
	
	
}

