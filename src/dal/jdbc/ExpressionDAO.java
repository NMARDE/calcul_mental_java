package dal.jdbc;

import bo.Expression;
import bo.Partie;
import bo.Utilisateur;
import dal.DAOFactory;
import dal.IExpressionDAO;
import dal.IPartieDAO;

import java.sql.*;
import java.util.Collection;

public class ExpressionDAO implements IExpressionDAO {

	private static final String CREATE_QUERY = "INSERT INTO `Expression`(`libelleExpression`, `resultatAttendu`, `reponseUser`, `idPartie`)  VALUES (?,?,?,?)";


	@Override
	public void create( Expression expression ) {

		try ( Connection connection = DAOFactory.getJDBCConnection();
			  PreparedStatement ps = connection.prepareStatement( CREATE_QUERY, Statement.RETURN_GENERATED_KEYS, ResultSet.CONCUR_UPDATABLE ) ) {
			ps.setString( 1, expression.afficherExpression());
			ps.setDouble( 2, expression.getResultatAttendu() );
			ps.setDouble( 3, expression.getReponseUser() );
			ps.setInt( 3, expression.getPartie().getId() );
			try( ResultSet rs = ps.executeQuery() ) {
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Override
	public void update(Expression object) {

	}


	@Override
	public void deleteById(Integer integer) {

	}

	@Override
	public void delete(Expression object) {

	}

	@Override
	public Expression findById(Integer integer) {
		return null;
	}

	@Override
	public Collection<Expression> findAll() {
		return null;
	}

}
