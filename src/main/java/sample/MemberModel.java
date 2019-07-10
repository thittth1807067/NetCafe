package sample;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberModel {


        public Member findByUsernameAndStatus(String username, Member status) {
            try {
                String sqlCommand = "select * from students where username = ? and status = ?";
                PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
                preparedStatement.setString(1, username);
                preparedStatement.setInt(2, status.getValue());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String rsUsername = resultSet.getString("username");
                    String rsPassword = resultSet.getString("password");
                    String rsFullName = resultSet.getString("fullName");
                    String rsAvatar = resultSet.getString("avatar");
                    Long rsRemaintime = resultSet.getLong("remaintime");
                    int rsStatus = resultSet.getInt("status");
                    Member member = new Member(txtUsername.get(), txtRemaintime.getText(), txtAvatar.getText());
                    member.setUsername(rsUsername);
                    member.setPassword(rsPassword);
                    member.setFullname(rsFullName);
                    member.setAvatar(rsAvatar);
                    member.setRemaintime(rsRemaintime);
                   member.setStatus(member.Status.findByValue(rsStatus));
                    return member;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        }

        public boolean save(Member member) {
            try {
                String sqlCommand = "insert into member (username, password, fullName, avatar, remaintime,  status) values (?,?,?,?,?,?)";
                PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
                preparedStatement.setString(1, member.getUsername());
                preparedStatement.setString(2, member.getPassword());
                preparedStatement.setString(3, member.getFullname());
                preparedStatement.setString(4, member.getAvatar());
                preparedStatement.setString(5, member.getRemaintime());
                preparedStatement.setInt(6, (Integer) member.getStatus());
                preparedStatement.execute();
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }

        public ArrayList<Member> getList() {
            ArrayList<Member> results = new ArrayList<>();
            try {
                String sqlCommand = "select * from member";
                PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String rsUsername = resultSet.getString("username");
                    String rsPassword = resultSet.getString("password");
                    String rsFullName = resultSet.getString("fullName");
                    String rsAvatar= resultSet.getString("avatar");
                    Long rsRemaintime= resultSet.getLong("remaintime");
                    int rsStatus = resultSet.getInt("status");
                   Member member = new Member(txtUsername.getText(), txtRemaintime.getText(), txtAvatar.getText());
                    member.setUsername(rsUsername);
                    member.setPassword(rsPassword);
                    member.setFullname(rsFullName);
                    member.setAvatar(rsAvatar);
                   member.setRemaintime(rsRemaintime);
                    member.setStatus(Member.Status.findByValue(rsStatus));
                    results.add(member);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return results;
        }
    }


