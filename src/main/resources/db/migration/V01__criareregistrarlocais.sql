CREATE TABLE Local (
  idLocal INT(11) PRIMARY KEY AUTO_INCREMENT,
  Local_Name VARCHAR(45) NOT NULL,
  Local_Cap INT(11) NOT NULL,
  Local_End VARCHAR(45) NOT NULL,
  Local_disp VARCHAR(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Usuario (
  idUsuario INT(11) PRIMARY KEY AUTO_INCREMENT,
  Usuario_name VARCHAR(45) NOT NULL,
  Usuario_idade INT(11) NOT NULL,
  Usuario_pass VARCHAR(45) NOT NULL,
  Usuario_end VARCHAR(45) NOT NULL,
  Usuario_email VARCHAR(45) NOT NULL,
  Usuario_nasc DATE NOT NULL,
  idReserva INT(11) NOT NULL,
  FOREIGN KEY (idReserva) REFERENCES Reserva (idReserva)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Evento (
  idEvento INT(11) PRIMARY KEY AUTO_INCREMENT,
  Evento_D_H DATETIME NOT NULL,
  Evento_Dur INT(11) NULL DEFAULT NULL,
  Evento_Num_Conv INT(11) NOT NULL,
  idLocal INT(11) NOT NULL,
  FOREIGN KEY (idLocal) REFERENCES Local (idLocal)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Funcionario (
  idFuncionario INT(11) PRIMARY KEY AUTO_INCREMENT,
  Funcionario_CPF VARCHAR(45) NOT NULL,
  Funcionario_End VARCHAR(45) NOT NULL,
  Funcionario_Cel INT(11) NOT NULL,
  idEvento INT(11) NOT NULL,
  FOREIGN KEY (idEvento) REFERENCES Evento (idEvento)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Reserva (
  idReserva INT(11) PRIMARY KEY AUTO_INCREMENT,
  Reserva_status VARCHAR(45) NOT NULL,
  Reserva_Data VARCHAR(45) NOT NULL,
  idLocal INT(11) NOT NULL,
  idFuncionario INT(11) NOT NULL,
  FOREIGN KEY (idLocal) REFERENCES Local (idLocal),
  FOREIGN KEY (idFuncionario) REFERENCES Funcionario (idFuncionario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Pagamento (
  idPagamento INT(11) PRIMARY KEY AUTO_INCREMENT,
  Pagamento_status VARCHAR(45) NOT NULL,
  idUsuario INT(11) NOT NULL,
  idLocal INT(11) NOT NULL,
  FOREIGN KEY (idUsuario) REFERENCES Usuario (idUsuario),
  FOREIGN KEY (idLocal) REFERENCES Local (idLocal)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE avaliacao (
  idavaliacao INT(11) PRIMARY KEY AUTO_INCREMENT,
  avaliacao_Desc VARCHAR(45) NOT NULL,
  idUsuario INT(11) NOT NULL,
  FOREIGN KEY (idUsuario) REFERENCES Usuario (idUsuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
