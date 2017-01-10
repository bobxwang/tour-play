package DBTables
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  import slick.collection.heterogeneous._
  import slick.collection.heterogeneous.syntax._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(TAccessCount.schema, TAddress.schema, TAdmin.schema, TAdvertisement.schema, TAllowiplist.schema, TApplygdLoan.schema, TApplyguangda.schema, TApplyguangfa.schema, TApplynany.schema, TAreaFull.schema, TBank.schema, TBankaActivity.schema, TBankaCarddetails.schema, TBanklimitconfig.schema, TBankthirdtype.schema, TBkarea.schema, TBkattache.schema, TBkattacheBank.schema, TBkattacheChangeaccount.schema, TBkattacheFeedback.schema, TBkattacheInvite.schema, TBkattacheMb.schema, TBkattacheMerge.schema, TBkattachePw.schema, TBkbank.schema, TBkbankcards.schema, TBkbankcity.schema, TBkbankconfig.schema, TBkbankthirdconfig.schema, TBkbanner.schema, TBkcardinfo.schema, TBkcharge.schema, TBkchat.schema, TBkchecklog.schema, TBkdeviceuser.schema, TBkLandpage.schema, TBkmessage.schema, TBkorder.schema, TBkoutuser.schema, TBkprocess.schema, TBkpromotion.schema, TBkstat.schema, TBktrade.schema, TCardapplyresult.schema, TCityFull.schema, TCreditcard.schema, TCreditcardDicNormal.schema, TCreditcarddicTag.schema, TCreditcardItem.schema, TCreditcardRule.schema, TDicRegion.schema, TEdbz.schema, TGfactivity.schema, TLink.schema, TLinkchannel.schema, TLinkjump.schema, TLoanapply.schema, TLoantype.schema, TPointAlipaychangecallback.schema, TPointAlipaynotify.schema, TPointAskpick.schema, TPointAttache.schema, TPointDetail.schema, TPointLlpcharge.schema, TPointRegula.schema, TProvinceFull.schema, TPushLog.schema, TSmslog.schema, TStatuslog.schema, TSysuser.schema, TTongjitrace.schema, TTradeThird.schema, TWelcomeTest.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table TAccessCount
   *  @param servicename Database column servicename SqlType(VARCHAR), Length(20,true), Default(None)
   *  @param machinename Database column machinename SqlType(VARCHAR), Length(15,true), Default(None)
   *  @param methodname Database column methodname SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param nvalue Database column nvalue SqlType(VARCHAR), Length(10,true), Default(None)
   *  @param createtime Database column createtime SqlType(DATETIME), Default(None) */
  case class TAccessCountRow(servicename: Option[String] = None, machinename: Option[String] = None, methodname: Option[String] = None, nvalue: Option[String] = None, createtime: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching TAccessCountRow objects using plain SQL queries */
  implicit def GetResultTAccessCountRow(implicit e0: GR[Option[String]], e1: GR[Option[java.sql.Timestamp]]): GR[TAccessCountRow] = GR{
    prs => import prs._
    TAccessCountRow.tupled((<<?[String], <<?[String], <<?[String], <<?[String], <<?[java.sql.Timestamp]))
  }
  /** Table description of table T_Access_Count. Objects of this class serve as prototypes for rows in queries. */
  class TAccessCount(_tableTag: Tag) extends Table[TAccessCountRow](_tableTag, "T_Access_Count") {
    def * = (servicename, machinename, methodname, nvalue, createtime) <> (TAccessCountRow.tupled, TAccessCountRow.unapply)

    /** Database column servicename SqlType(VARCHAR), Length(20,true), Default(None) */
    val servicename: Rep[Option[String]] = column[Option[String]]("servicename", O.Length(20,varying=true), O.Default(None))
    /** Database column machinename SqlType(VARCHAR), Length(15,true), Default(None) */
    val machinename: Rep[Option[String]] = column[Option[String]]("machinename", O.Length(15,varying=true), O.Default(None))
    /** Database column methodname SqlType(VARCHAR), Length(45,true), Default(None) */
    val methodname: Rep[Option[String]] = column[Option[String]]("methodname", O.Length(45,varying=true), O.Default(None))
    /** Database column nvalue SqlType(VARCHAR), Length(10,true), Default(None) */
    val nvalue: Rep[Option[String]] = column[Option[String]]("nvalue", O.Length(10,varying=true), O.Default(None))
    /** Database column createtime SqlType(DATETIME), Default(None) */
    val createtime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("createtime", O.Default(None))
  }
  /** Collection-like TableQuery object for table TAccessCount */
  lazy val TAccessCount = new TableQuery(tag => new TAccessCount(tag))

  /** Entity class storing rows of table TAddress
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param country Database column country SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param province Database column province SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param city Database column city SqlType(VARCHAR), Length(50,true), Default(None) */
  case class TAddressRow(id: Int, country: Option[String] = None, province: Option[String] = None, city: Option[String] = None)
  /** GetResult implicit for fetching TAddressRow objects using plain SQL queries */
  implicit def GetResultTAddressRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[TAddressRow] = GR{
    prs => import prs._
    TAddressRow.tupled((<<[Int], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table T_Address. Objects of this class serve as prototypes for rows in queries. */
  class TAddress(_tableTag: Tag) extends Table[TAddressRow](_tableTag, "T_Address") {
    def * = (id, country, province, city) <> (TAddressRow.tupled, TAddressRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), country, province, city).shaped.<>({r=>import r._; _1.map(_=> TAddressRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column country SqlType(VARCHAR), Length(50,true), Default(None) */
    val country: Rep[Option[String]] = column[Option[String]]("country", O.Length(50,varying=true), O.Default(None))
    /** Database column province SqlType(VARCHAR), Length(50,true), Default(None) */
    val province: Rep[Option[String]] = column[Option[String]]("province", O.Length(50,varying=true), O.Default(None))
    /** Database column city SqlType(VARCHAR), Length(50,true), Default(None) */
    val city: Rep[Option[String]] = column[Option[String]]("city", O.Length(50,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table TAddress */
  lazy val TAddress = new TableQuery(tag => new TAddress(tag))

  /** Entity class storing rows of table TAdmin
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param username Database column UserName SqlType(VARCHAR), Length(40,true), Default()
   *  @param password Database column Password SqlType(VARCHAR), Length(100,true), Default()
   *  @param role Database column Role SqlType(INT), Default(0)
   *  @param createtime Database column CreateTime SqlType(DATETIME)
   *  @param lastmodifytime Database column LastModifyTime SqlType(DATETIME)
   *  @param state Database column State SqlType(INT), Default(1) */
  case class TAdminRow(autoid: Long, username: String = "", password: String = "", role: Int = 0, createtime: java.sql.Timestamp, lastmodifytime: java.sql.Timestamp, state: Int = 1)
  /** GetResult implicit for fetching TAdminRow objects using plain SQL queries */
  implicit def GetResultTAdminRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[java.sql.Timestamp]): GR[TAdminRow] = GR{
    prs => import prs._
    TAdminRow.tupled((<<[Long], <<[String], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[Int]))
  }
  /** Table description of table T_Admin. Objects of this class serve as prototypes for rows in queries. */
  class TAdmin(_tableTag: Tag) extends Table[TAdminRow](_tableTag, "T_Admin") {
    def * = (autoid, username, password, role, createtime, lastmodifytime, state) <> (TAdminRow.tupled, TAdminRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(username), Rep.Some(password), Rep.Some(role), Rep.Some(createtime), Rep.Some(lastmodifytime), Rep.Some(state)).shaped.<>({r=>import r._; _1.map(_=> TAdminRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column UserName SqlType(VARCHAR), Length(40,true), Default() */
    val username: Rep[String] = column[String]("UserName", O.Length(40,varying=true), O.Default(""))
    /** Database column Password SqlType(VARCHAR), Length(100,true), Default() */
    val password: Rep[String] = column[String]("Password", O.Length(100,varying=true), O.Default(""))
    /** Database column Role SqlType(INT), Default(0) */
    val role: Rep[Int] = column[Int]("Role", O.Default(0))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column State SqlType(INT), Default(1) */
    val state: Rep[Int] = column[Int]("State", O.Default(1))

    /** Uniqueness Index over (username) (database name uq_UserName) */
    val index1 = index("uq_UserName", username, unique=true)
  }
  /** Collection-like TableQuery object for table TAdmin */
  lazy val TAdmin = new TableQuery(tag => new TAdmin(tag))

  /** Entity class storing rows of table TAdvertisement
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param title Database column Title SqlType(VARCHAR), Length(100,true)
   *  @param picurl Database column PicUrl SqlType(VARCHAR), Length(100,true)
   *  @param clickurl Database column ClickUrl SqlType(VARCHAR), Length(100,true)
   *  @param state Database column State SqlType(INT)
   *  @param plat Database column Plat SqlType(INT)
   *  @param staytime Database column StayTime SqlType(INT)
   *  @param citycode Database column CityCode SqlType(VARCHAR), Length(2000,true)
   *  @param cityname Database column CityName SqlType(VARCHAR), Length(5000,true)
   *  @param createtime Database column CreateTime SqlType(DATETIME)
   *  @param modifytime Database column ModifyTime SqlType(DATETIME) */
  case class TAdvertisementRow(autoid: Long, title: String, picurl: String, clickurl: String, state: Int, plat: Int, staytime: Int, citycode: String, cityname: String, createtime: java.sql.Timestamp, modifytime: java.sql.Timestamp)
  /** GetResult implicit for fetching TAdvertisementRow objects using plain SQL queries */
  implicit def GetResultTAdvertisementRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[java.sql.Timestamp]): GR[TAdvertisementRow] = GR{
    prs => import prs._
    TAdvertisementRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[Int], <<[Int], <<[Int], <<[String], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_Advertisement. Objects of this class serve as prototypes for rows in queries. */
  class TAdvertisement(_tableTag: Tag) extends Table[TAdvertisementRow](_tableTag, "T_Advertisement") {
    def * = (autoid, title, picurl, clickurl, state, plat, staytime, citycode, cityname, createtime, modifytime) <> (TAdvertisementRow.tupled, TAdvertisementRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(title), Rep.Some(picurl), Rep.Some(clickurl), Rep.Some(state), Rep.Some(plat), Rep.Some(staytime), Rep.Some(citycode), Rep.Some(cityname), Rep.Some(createtime), Rep.Some(modifytime)).shaped.<>({r=>import r._; _1.map(_=> TAdvertisementRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column Title SqlType(VARCHAR), Length(100,true) */
    val title: Rep[String] = column[String]("Title", O.Length(100,varying=true))
    /** Database column PicUrl SqlType(VARCHAR), Length(100,true) */
    val picurl: Rep[String] = column[String]("PicUrl", O.Length(100,varying=true))
    /** Database column ClickUrl SqlType(VARCHAR), Length(100,true) */
    val clickurl: Rep[String] = column[String]("ClickUrl", O.Length(100,varying=true))
    /** Database column State SqlType(INT) */
    val state: Rep[Int] = column[Int]("State")
    /** Database column Plat SqlType(INT) */
    val plat: Rep[Int] = column[Int]("Plat")
    /** Database column StayTime SqlType(INT) */
    val staytime: Rep[Int] = column[Int]("StayTime")
    /** Database column CityCode SqlType(VARCHAR), Length(2000,true) */
    val citycode: Rep[String] = column[String]("CityCode", O.Length(2000,varying=true))
    /** Database column CityName SqlType(VARCHAR), Length(5000,true) */
    val cityname: Rep[String] = column[String]("CityName", O.Length(5000,varying=true))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column ModifyTime SqlType(DATETIME) */
    val modifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("ModifyTime")
  }
  /** Collection-like TableQuery object for table TAdvertisement */
  lazy val TAdvertisement = new TableQuery(tag => new TAdvertisement(tag))

  /** Entity class storing rows of table TAllowiplist
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param ipaddress Database column IpAddress SqlType(VARCHAR), Length(100,true), Default(0.0.0.0)
   *  @param `type` Database column Type SqlType(INT), Default(0)
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TAllowiplistRow(autoid: Long, ipaddress: String = "0.0.0.0", `type`: Int = 0, createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TAllowiplistRow objects using plain SQL queries */
  implicit def GetResultTAllowiplistRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[java.sql.Timestamp]): GR[TAllowiplistRow] = GR{
    prs => import prs._
    TAllowiplistRow.tupled((<<[Long], <<[String], <<[Int], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_AllowIpList. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class TAllowiplist(_tableTag: Tag) extends Table[TAllowiplistRow](_tableTag, "T_AllowIpList") {
    def * = (autoid, ipaddress, `type`, createtime) <> (TAllowiplistRow.tupled, TAllowiplistRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(ipaddress), Rep.Some(`type`), Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TAllowiplistRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column IpAddress SqlType(VARCHAR), Length(100,true), Default(0.0.0.0) */
    val ipaddress: Rep[String] = column[String]("IpAddress", O.Length(100,varying=true), O.Default("0.0.0.0"))
    /** Database column Type SqlType(INT), Default(0)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Int] = column[Int]("Type", O.Default(0))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TAllowiplist */
  lazy val TAllowiplist = new TableQuery(tag => new TAllowiplist(tag))

  /** Entity class storing rows of table TApplygdLoan
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column UserId SqlType(BIGINT)
   *  @param truename Database column TrueName SqlType(VARCHAR), Length(255,true)
   *  @param city Database column City SqlType(VARCHAR), Length(45,true)
   *  @param area Database column Area SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param mobile Database column Mobile SqlType(VARCHAR), Length(255,true)
   *  @param occupation Database column Occupation SqlType(VARCHAR), Length(45,true)
   *  @param income Database column InCome SqlType(VARCHAR), Length(45,true)
   *  @param hashouse Database column HasHouse SqlType(TINYINT)
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TApplygdLoanRow(autoid: Long, userid: Long, truename: String, city: String, area: Option[String] = None, mobile: String, occupation: String, income: String, hashouse: Byte, createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TApplygdLoanRow objects using plain SQL queries */
  implicit def GetResultTApplygdLoanRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Option[String]], e3: GR[Byte], e4: GR[java.sql.Timestamp]): GR[TApplygdLoanRow] = GR{
    prs => import prs._
    TApplygdLoanRow.tupled((<<[Long], <<[Long], <<[String], <<[String], <<?[String], <<[String], <<[String], <<[String], <<[Byte], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_ApplyGD_Loan. Objects of this class serve as prototypes for rows in queries. */
  class TApplygdLoan(_tableTag: Tag) extends Table[TApplygdLoanRow](_tableTag, "T_ApplyGD_Loan") {
    def * = (autoid, userid, truename, city, area, mobile, occupation, income, hashouse, createtime) <> (TApplygdLoanRow.tupled, TApplygdLoanRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(userid), Rep.Some(truename), Rep.Some(city), area, Rep.Some(mobile), Rep.Some(occupation), Rep.Some(income), Rep.Some(hashouse), Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TApplygdLoanRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get, _7.get, _8.get, _9.get, _10.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column UserId SqlType(BIGINT) */
    val userid: Rep[Long] = column[Long]("UserId")
    /** Database column TrueName SqlType(VARCHAR), Length(255,true) */
    val truename: Rep[String] = column[String]("TrueName", O.Length(255,varying=true))
    /** Database column City SqlType(VARCHAR), Length(45,true) */
    val city: Rep[String] = column[String]("City", O.Length(45,varying=true))
    /** Database column Area SqlType(VARCHAR), Length(45,true), Default(None) */
    val area: Rep[Option[String]] = column[Option[String]]("Area", O.Length(45,varying=true), O.Default(None))
    /** Database column Mobile SqlType(VARCHAR), Length(255,true) */
    val mobile: Rep[String] = column[String]("Mobile", O.Length(255,varying=true))
    /** Database column Occupation SqlType(VARCHAR), Length(45,true) */
    val occupation: Rep[String] = column[String]("Occupation", O.Length(45,varying=true))
    /** Database column InCome SqlType(VARCHAR), Length(45,true) */
    val income: Rep[String] = column[String]("InCome", O.Length(45,varying=true))
    /** Database column HasHouse SqlType(TINYINT) */
    val hashouse: Rep[Byte] = column[Byte]("HasHouse")
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TApplygdLoan */
  lazy val TApplygdLoan = new TableQuery(tag => new TApplygdLoan(tag))

  /** Entity class storing rows of table TApplyguangda
   *  @param autoid Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column UserID SqlType(BIGINT)
   *  @param username Database column UserName SqlType(VARCHAR), Length(255,true)
   *  @param contract Database column Contract SqlType(VARCHAR), Length(255,true)
   *  @param organization Database column Organization SqlType(VARCHAR), Length(500,true)
   *  @param housemode Database column HouseMode SqlType(VARCHAR), Length(500,true)
   *  @param carmode Database column CarMode SqlType(VARCHAR), Length(500,true)
   *  @param carprice Database column CarPrice SqlType(VARCHAR), Length(45,true)
   *  @param cardmode Database column CardMode SqlType(VARCHAR), Length(200,true)
   *  @param idcard Database column IdCard SqlType(VARCHAR), Length(255,true)
   *  @param createtime Database column CreateTime SqlType(DATETIME), Default(None)
   *  @param cityname Database column CityName SqlType(VARCHAR), Length(45,true), Default(None) */
  case class TApplyguangdaRow(autoid: Long, userid: Long, username: String, contract: String, organization: String, housemode: String, carmode: String, carprice: String, cardmode: String, idcard: String, createtime: Option[java.sql.Timestamp] = None, cityname: Option[String] = None)
  /** GetResult implicit for fetching TApplyguangdaRow objects using plain SQL queries */
  implicit def GetResultTApplyguangdaRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Option[java.sql.Timestamp]], e3: GR[Option[String]]): GR[TApplyguangdaRow] = GR{
    prs => import prs._
    TApplyguangdaRow.tupled((<<[Long], <<[Long], <<[String], <<[String], <<[String], <<[String], <<[String], <<[String], <<[String], <<[String], <<?[java.sql.Timestamp], <<?[String]))
  }
  /** Table description of table T_Applyguangda. Objects of this class serve as prototypes for rows in queries. */
  class TApplyguangda(_tableTag: Tag) extends Table[TApplyguangdaRow](_tableTag, "T_Applyguangda") {
    def * = (autoid, userid, username, contract, organization, housemode, carmode, carprice, cardmode, idcard, createtime, cityname) <> (TApplyguangdaRow.tupled, TApplyguangdaRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(userid), Rep.Some(username), Rep.Some(contract), Rep.Some(organization), Rep.Some(housemode), Rep.Some(carmode), Rep.Some(carprice), Rep.Some(cardmode), Rep.Some(idcard), createtime, cityname).shaped.<>({r=>import r._; _1.map(_=> TApplyguangdaRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11, _12)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoID", O.AutoInc, O.PrimaryKey)
    /** Database column UserID SqlType(BIGINT) */
    val userid: Rep[Long] = column[Long]("UserID")
    /** Database column UserName SqlType(VARCHAR), Length(255,true) */
    val username: Rep[String] = column[String]("UserName", O.Length(255,varying=true))
    /** Database column Contract SqlType(VARCHAR), Length(255,true) */
    val contract: Rep[String] = column[String]("Contract", O.Length(255,varying=true))
    /** Database column Organization SqlType(VARCHAR), Length(500,true) */
    val organization: Rep[String] = column[String]("Organization", O.Length(500,varying=true))
    /** Database column HouseMode SqlType(VARCHAR), Length(500,true) */
    val housemode: Rep[String] = column[String]("HouseMode", O.Length(500,varying=true))
    /** Database column CarMode SqlType(VARCHAR), Length(500,true) */
    val carmode: Rep[String] = column[String]("CarMode", O.Length(500,varying=true))
    /** Database column CarPrice SqlType(VARCHAR), Length(45,true) */
    val carprice: Rep[String] = column[String]("CarPrice", O.Length(45,varying=true))
    /** Database column CardMode SqlType(VARCHAR), Length(200,true) */
    val cardmode: Rep[String] = column[String]("CardMode", O.Length(200,varying=true))
    /** Database column IdCard SqlType(VARCHAR), Length(255,true) */
    val idcard: Rep[String] = column[String]("IdCard", O.Length(255,varying=true))
    /** Database column CreateTime SqlType(DATETIME), Default(None) */
    val createtime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("CreateTime", O.Default(None))
    /** Database column CityName SqlType(VARCHAR), Length(45,true), Default(None) */
    val cityname: Rep[Option[String]] = column[Option[String]]("CityName", O.Length(45,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table TApplyguangda */
  lazy val TApplyguangda = new TableQuery(tag => new TApplyguangda(tag))

  /** Entity class storing rows of table TApplyguangfa
   *  @param autoid Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column UserID SqlType(BIGINT)
   *  @param username Database column UserName SqlType(VARCHAR), Length(255,true)
   *  @param age Database column Age SqlType(VARCHAR), Length(255,true)
   *  @param mobile Database column Mobile SqlType(VARCHAR), Length(255,true)
   *  @param company Database column Company SqlType(VARCHAR), Length(500,true)
   *  @param occupation Database column Occupation SqlType(VARCHAR), Length(500,true)
   *  @param province Database column Province SqlType(VARCHAR), Length(45,true)
   *  @param city Database column City SqlType(VARCHAR), Length(45,true)
   *  @param area Database column Area SqlType(VARCHAR), Length(45,true)
   *  @param companyaddress Database column CompanyAddress SqlType(VARCHAR), Length(500,true)
   *  @param education Database column Education SqlType(VARCHAR), Length(45,true)
   *  @param hascard Database column Hascard SqlType(VARCHAR), Length(200,true)
   *  @param contactway Database column Contactway SqlType(VARCHAR), Length(255,true)
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TApplyguangfaRow(autoid: Long, userid: Long, username: String, age: String, mobile: String, company: String, occupation: String, province: String, city: String, area: String, companyaddress: String, education: String, hascard: String, contactway: String, createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TApplyguangfaRow objects using plain SQL queries */
  implicit def GetResultTApplyguangfaRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[TApplyguangfaRow] = GR{
    prs => import prs._
    TApplyguangfaRow.tupled((<<[Long], <<[Long], <<[String], <<[String], <<[String], <<[String], <<[String], <<[String], <<[String], <<[String], <<[String], <<[String], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_Applyguangfa. Objects of this class serve as prototypes for rows in queries. */
  class TApplyguangfa(_tableTag: Tag) extends Table[TApplyguangfaRow](_tableTag, "T_Applyguangfa") {
    def * = (autoid, userid, username, age, mobile, company, occupation, province, city, area, companyaddress, education, hascard, contactway, createtime) <> (TApplyguangfaRow.tupled, TApplyguangfaRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(userid), Rep.Some(username), Rep.Some(age), Rep.Some(mobile), Rep.Some(company), Rep.Some(occupation), Rep.Some(province), Rep.Some(city), Rep.Some(area), Rep.Some(companyaddress), Rep.Some(education), Rep.Some(hascard), Rep.Some(contactway), Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TApplyguangfaRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoID", O.AutoInc, O.PrimaryKey)
    /** Database column UserID SqlType(BIGINT) */
    val userid: Rep[Long] = column[Long]("UserID")
    /** Database column UserName SqlType(VARCHAR), Length(255,true) */
    val username: Rep[String] = column[String]("UserName", O.Length(255,varying=true))
    /** Database column Age SqlType(VARCHAR), Length(255,true) */
    val age: Rep[String] = column[String]("Age", O.Length(255,varying=true))
    /** Database column Mobile SqlType(VARCHAR), Length(255,true) */
    val mobile: Rep[String] = column[String]("Mobile", O.Length(255,varying=true))
    /** Database column Company SqlType(VARCHAR), Length(500,true) */
    val company: Rep[String] = column[String]("Company", O.Length(500,varying=true))
    /** Database column Occupation SqlType(VARCHAR), Length(500,true) */
    val occupation: Rep[String] = column[String]("Occupation", O.Length(500,varying=true))
    /** Database column Province SqlType(VARCHAR), Length(45,true) */
    val province: Rep[String] = column[String]("Province", O.Length(45,varying=true))
    /** Database column City SqlType(VARCHAR), Length(45,true) */
    val city: Rep[String] = column[String]("City", O.Length(45,varying=true))
    /** Database column Area SqlType(VARCHAR), Length(45,true) */
    val area: Rep[String] = column[String]("Area", O.Length(45,varying=true))
    /** Database column CompanyAddress SqlType(VARCHAR), Length(500,true) */
    val companyaddress: Rep[String] = column[String]("CompanyAddress", O.Length(500,varying=true))
    /** Database column Education SqlType(VARCHAR), Length(45,true) */
    val education: Rep[String] = column[String]("Education", O.Length(45,varying=true))
    /** Database column Hascard SqlType(VARCHAR), Length(200,true) */
    val hascard: Rep[String] = column[String]("Hascard", O.Length(200,varying=true))
    /** Database column Contactway SqlType(VARCHAR), Length(255,true) */
    val contactway: Rep[String] = column[String]("Contactway", O.Length(255,varying=true))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TApplyguangfa */
  lazy val TApplyguangfa = new TableQuery(tag => new TApplyguangfa(tag))

  /** Row type of table TApplynany */
  type TApplynanyRow = HCons[Long,HCons[Long,HCons[Int,HCons[String,HCons[Int,HCons[String,HCons[String,HCons[Int,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[Int,HCons[String,HCons[String,HCons[Int,HCons[Int,HCons[String,HCons[String,HCons[String,HCons[Int,HCons[String,HCons[Int,HCons[java.sql.Timestamp,HCons[Option[String],HCons[Option[String],HCons[Option[String],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for TApplynanyRow providing default values if available in the database schema. */
  def TApplynanyRow(autoid: Long, userid: Long, card: Int, truename: String, cardtype: Int, cardno: String, birth: String, sex: Int, homeprov: String, homeaddr: String, email: String, mobile: String, company: String, companyaddr: String, companyarea: String, companytel: String, joblevel: Int, jobgroup: String, jobname: String, jobtype: Int, friendgx: Int, friendmobile: String, friendname: String, qinshuname: String, qinshugx: Int, qinshumobile: String, mailaddr: Int, createtime: java.sql.Timestamp, cardaddr: Option[String] = None, cardwhosend: Option[String] = None, namepy: Option[String] = None): TApplynanyRow = {
    autoid :: userid :: card :: truename :: cardtype :: cardno :: birth :: sex :: homeprov :: homeaddr :: email :: mobile :: company :: companyaddr :: companyarea :: companytel :: joblevel :: jobgroup :: jobname :: jobtype :: friendgx :: friendmobile :: friendname :: qinshuname :: qinshugx :: qinshumobile :: mailaddr :: createtime :: cardaddr :: cardwhosend :: namepy :: HNil
  }
  /** GetResult implicit for fetching TApplynanyRow objects using plain SQL queries */
  implicit def GetResultTApplynanyRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[String], e3: GR[java.sql.Timestamp], e4: GR[Option[String]]): GR[TApplynanyRow] = GR{
    prs => import prs._
    <<[Long] :: <<[Long] :: <<[Int] :: <<[String] :: <<[Int] :: <<[String] :: <<[String] :: <<[Int] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[Int] :: <<[String] :: <<[String] :: <<[Int] :: <<[Int] :: <<[String] :: <<[String] :: <<[String] :: <<[Int] :: <<[String] :: <<[Int] :: <<[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[String] :: HNil
  }
  /** Table description of table T_ApplyNany. Objects of this class serve as prototypes for rows in queries. */
  class TApplynany(_tableTag: Tag) extends Table[TApplynanyRow](_tableTag, "T_ApplyNany") {
    def * = autoid :: userid :: card :: truename :: cardtype :: cardno :: birth :: sex :: homeprov :: homeaddr :: email :: mobile :: company :: companyaddr :: companyarea :: companytel :: joblevel :: jobgroup :: jobname :: jobtype :: friendgx :: friendmobile :: friendname :: qinshuname :: qinshugx :: qinshumobile :: mailaddr :: createtime :: cardaddr :: cardwhosend :: namepy :: HNil

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column UserId SqlType(BIGINT) */
    val userid: Rep[Long] = column[Long]("UserId")
    /** Database column Card SqlType(INT) */
    val card: Rep[Int] = column[Int]("Card")
    /** Database column TrueName SqlType(VARCHAR), Length(255,true) */
    val truename: Rep[String] = column[String]("TrueName", O.Length(255,varying=true))
    /** Database column CardType SqlType(INT) */
    val cardtype: Rep[Int] = column[Int]("CardType")
    /** Database column CardNo SqlType(VARCHAR), Length(255,true) */
    val cardno: Rep[String] = column[String]("CardNo", O.Length(255,varying=true))
    /** Database column Birth SqlType(VARCHAR), Length(45,true) */
    val birth: Rep[String] = column[String]("Birth", O.Length(45,varying=true))
    /** Database column Sex SqlType(INT) */
    val sex: Rep[Int] = column[Int]("Sex")
    /** Database column HomeProv SqlType(VARCHAR), Length(100,true) */
    val homeprov: Rep[String] = column[String]("HomeProv", O.Length(100,varying=true))
    /** Database column HomeAddr SqlType(VARCHAR), Length(255,true) */
    val homeaddr: Rep[String] = column[String]("HomeAddr", O.Length(255,varying=true))
    /** Database column Email SqlType(VARCHAR), Length(45,true) */
    val email: Rep[String] = column[String]("Email", O.Length(45,varying=true))
    /** Database column Mobile SqlType(VARCHAR), Length(255,true) */
    val mobile: Rep[String] = column[String]("Mobile", O.Length(255,varying=true))
    /** Database column Company SqlType(VARCHAR), Length(255,true) */
    val company: Rep[String] = column[String]("Company", O.Length(255,varying=true))
    /** Database column CompanyAddr SqlType(VARCHAR), Length(255,true) */
    val companyaddr: Rep[String] = column[String]("CompanyAddr", O.Length(255,varying=true))
    /** Database column CompanyArea SqlType(VARCHAR), Length(100,true) */
    val companyarea: Rep[String] = column[String]("CompanyArea", O.Length(100,varying=true))
    /** Database column CompanyTel SqlType(VARCHAR), Length(45,true) */
    val companytel: Rep[String] = column[String]("CompanyTel", O.Length(45,varying=true))
    /** Database column JobLevel SqlType(INT) */
    val joblevel: Rep[Int] = column[Int]("JobLevel")
    /** Database column JobGroup SqlType(VARCHAR), Length(45,true) */
    val jobgroup: Rep[String] = column[String]("JobGroup", O.Length(45,varying=true))
    /** Database column JobName SqlType(VARCHAR), Length(100,true) */
    val jobname: Rep[String] = column[String]("JobName", O.Length(100,varying=true))
    /** Database column JobType SqlType(INT) */
    val jobtype: Rep[Int] = column[Int]("JobType")
    /** Database column FriendGx SqlType(INT) */
    val friendgx: Rep[Int] = column[Int]("FriendGx")
    /** Database column FriendMobile SqlType(VARCHAR), Length(255,true) */
    val friendmobile: Rep[String] = column[String]("FriendMobile", O.Length(255,varying=true))
    /** Database column FriendName SqlType(VARCHAR), Length(45,true) */
    val friendname: Rep[String] = column[String]("FriendName", O.Length(45,varying=true))
    /** Database column QinshuName SqlType(VARCHAR), Length(45,true) */
    val qinshuname: Rep[String] = column[String]("QinshuName", O.Length(45,varying=true))
    /** Database column QinshuGX SqlType(INT) */
    val qinshugx: Rep[Int] = column[Int]("QinshuGX")
    /** Database column QinshuMobile SqlType(VARCHAR), Length(255,true) */
    val qinshumobile: Rep[String] = column[String]("QinshuMobile", O.Length(255,varying=true))
    /** Database column MailAddr SqlType(INT) */
    val mailaddr: Rep[Int] = column[Int]("MailAddr")
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column CardAddr SqlType(VARCHAR), Length(200,true), Default(None) */
    val cardaddr: Rep[Option[String]] = column[Option[String]]("CardAddr", O.Length(200,varying=true), O.Default(None))
    /** Database column CardWhoSend SqlType(VARCHAR), Length(200,true), Default(None) */
    val cardwhosend: Rep[Option[String]] = column[Option[String]]("CardWhoSend", O.Length(200,varying=true), O.Default(None))
    /** Database column NamePy SqlType(VARCHAR), Length(45,true), Default(None) */
    val namepy: Rep[Option[String]] = column[Option[String]]("NamePy", O.Length(45,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table TApplynany */
  lazy val TApplynany = new TableQuery(tag => new TApplynany(tag))

  /** Entity class storing rows of table TAreaFull
   *  @param areaid Database column AreaID SqlType(INT), PrimaryKey, Default(0)
   *  @param code Database column Code SqlType(VARCHAR), Length(6,true), Default()
   *  @param name Database column Name SqlType(VARCHAR), Length(50,true), Default()
   *  @param citycode Database column CityCode SqlType(VARCHAR), Length(6,true), Default()
   *  @param deletestatus Database column DeleteStatus SqlType(BIT) */
  case class TAreaFullRow(areaid: Int = 0, code: String = "", name: String = "", citycode: String = "", deletestatus: Boolean)
  /** GetResult implicit for fetching TAreaFullRow objects using plain SQL queries */
  implicit def GetResultTAreaFullRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean]): GR[TAreaFullRow] = GR{
    prs => import prs._
    TAreaFullRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[Boolean]))
  }
  /** Table description of table T_Area_Full. Objects of this class serve as prototypes for rows in queries. */
  class TAreaFull(_tableTag: Tag) extends Table[TAreaFullRow](_tableTag, "T_Area_Full") {
    def * = (areaid, code, name, citycode, deletestatus) <> (TAreaFullRow.tupled, TAreaFullRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(areaid), Rep.Some(code), Rep.Some(name), Rep.Some(citycode), Rep.Some(deletestatus)).shaped.<>({r=>import r._; _1.map(_=> TAreaFullRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AreaID SqlType(INT), PrimaryKey, Default(0) */
    val areaid: Rep[Int] = column[Int]("AreaID", O.PrimaryKey, O.Default(0))
    /** Database column Code SqlType(VARCHAR), Length(6,true), Default() */
    val code: Rep[String] = column[String]("Code", O.Length(6,varying=true), O.Default(""))
    /** Database column Name SqlType(VARCHAR), Length(50,true), Default() */
    val name: Rep[String] = column[String]("Name", O.Length(50,varying=true), O.Default(""))
    /** Database column CityCode SqlType(VARCHAR), Length(6,true), Default() */
    val citycode: Rep[String] = column[String]("CityCode", O.Length(6,varying=true), O.Default(""))
    /** Database column DeleteStatus SqlType(BIT) */
    val deletestatus: Rep[Boolean] = column[Boolean]("DeleteStatus")
  }
  /** Collection-like TableQuery object for table TAreaFull */
  lazy val TAreaFull = new TableQuery(tag => new TAreaFull(tag))

  /** Entity class storing rows of table TBank
   *  @param bankid Database column BankID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param bankname Database column BankName SqlType(VARCHAR), Length(100,true), Default()
   *  @param createtime Database column CreateTime SqlType(DATETIME)
   *  @param isdeleted Database column IsDeleted SqlType(BIT)
   *  @param deletetime Database column DeleteTime SqlType(DATETIME)
   *  @param fullname Database column FullName SqlType(VARCHAR), Length(50,true), Default()
   *  @param simplename Database column SimpleName SqlType(VARCHAR), Length(50,true), Default()
   *  @param logo Database column Logo SqlType(VARCHAR), Length(255,true), Default()
   *  @param shorttel Database column ShortTel SqlType(VARCHAR), Length(50,true), Default()
   *  @param longtel Database column LongTel SqlType(VARCHAR), Length(50,true), Default()
   *  @param maxfreepeirod Database column MaxFreePeirod SqlType(INT), Default(0)
   *  @param lastmodifytime Database column LastModifyTime SqlType(DATETIME)
   *  @param orderindex Database column OrderIndex SqlType(INT), Default(0)
   *  @param billtype Database column BillType SqlType(INT), Default(0)
   *  @param bankmark Database column BankMark SqlType(VARCHAR), Length(50,true), Default()
   *  @param pinyin Database column Pinyin SqlType(VARCHAR), Length(100,true), Default(None) */
  case class TBankRow(bankid: Long, bankname: String = "", createtime: java.sql.Timestamp, isdeleted: Boolean, deletetime: java.sql.Timestamp, fullname: String = "", simplename: String = "", logo: String = "", shorttel: String = "", longtel: String = "", maxfreepeirod: Int = 0, lastmodifytime: java.sql.Timestamp, orderindex: Int = 0, billtype: Int = 0, bankmark: String = "", pinyin: Option[String] = None)
  /** GetResult implicit for fetching TBankRow objects using plain SQL queries */
  implicit def GetResultTBankRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Boolean], e4: GR[Int], e5: GR[Option[String]]): GR[TBankRow] = GR{
    prs => import prs._
    TBankRow.tupled((<<[Long], <<[String], <<[java.sql.Timestamp], <<[Boolean], <<[java.sql.Timestamp], <<[String], <<[String], <<[String], <<[String], <<[String], <<[Int], <<[java.sql.Timestamp], <<[Int], <<[Int], <<[String], <<?[String]))
  }
  /** Table description of table T_Bank. Objects of this class serve as prototypes for rows in queries. */
  class TBank(_tableTag: Tag) extends Table[TBankRow](_tableTag, "T_Bank") {
    def * = (bankid, bankname, createtime, isdeleted, deletetime, fullname, simplename, logo, shorttel, longtel, maxfreepeirod, lastmodifytime, orderindex, billtype, bankmark, pinyin) <> (TBankRow.tupled, TBankRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(bankid), Rep.Some(bankname), Rep.Some(createtime), Rep.Some(isdeleted), Rep.Some(deletetime), Rep.Some(fullname), Rep.Some(simplename), Rep.Some(logo), Rep.Some(shorttel), Rep.Some(longtel), Rep.Some(maxfreepeirod), Rep.Some(lastmodifytime), Rep.Some(orderindex), Rep.Some(billtype), Rep.Some(bankmark), pinyin).shaped.<>({r=>import r._; _1.map(_=> TBankRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column BankID SqlType(BIGINT), AutoInc, PrimaryKey */
    val bankid: Rep[Long] = column[Long]("BankID", O.AutoInc, O.PrimaryKey)
    /** Database column BankName SqlType(VARCHAR), Length(100,true), Default() */
    val bankname: Rep[String] = column[String]("BankName", O.Length(100,varying=true), O.Default(""))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column IsDeleted SqlType(BIT) */
    val isdeleted: Rep[Boolean] = column[Boolean]("IsDeleted")
    /** Database column DeleteTime SqlType(DATETIME) */
    val deletetime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("DeleteTime")
    /** Database column FullName SqlType(VARCHAR), Length(50,true), Default() */
    val fullname: Rep[String] = column[String]("FullName", O.Length(50,varying=true), O.Default(""))
    /** Database column SimpleName SqlType(VARCHAR), Length(50,true), Default() */
    val simplename: Rep[String] = column[String]("SimpleName", O.Length(50,varying=true), O.Default(""))
    /** Database column Logo SqlType(VARCHAR), Length(255,true), Default() */
    val logo: Rep[String] = column[String]("Logo", O.Length(255,varying=true), O.Default(""))
    /** Database column ShortTel SqlType(VARCHAR), Length(50,true), Default() */
    val shorttel: Rep[String] = column[String]("ShortTel", O.Length(50,varying=true), O.Default(""))
    /** Database column LongTel SqlType(VARCHAR), Length(50,true), Default() */
    val longtel: Rep[String] = column[String]("LongTel", O.Length(50,varying=true), O.Default(""))
    /** Database column MaxFreePeirod SqlType(INT), Default(0) */
    val maxfreepeirod: Rep[Int] = column[Int]("MaxFreePeirod", O.Default(0))
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column OrderIndex SqlType(INT), Default(0) */
    val orderindex: Rep[Int] = column[Int]("OrderIndex", O.Default(0))
    /** Database column BillType SqlType(INT), Default(0) */
    val billtype: Rep[Int] = column[Int]("BillType", O.Default(0))
    /** Database column BankMark SqlType(VARCHAR), Length(50,true), Default() */
    val bankmark: Rep[String] = column[String]("BankMark", O.Length(50,varying=true), O.Default(""))
    /** Database column Pinyin SqlType(VARCHAR), Length(100,true), Default(None) */
    val pinyin: Rep[Option[String]] = column[Option[String]]("Pinyin", O.Length(100,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table TBank */
  lazy val TBank = new TableQuery(tag => new TBank(tag))

  /** Entity class storing rows of table TBankaActivity
   *  @param id Database column ID SqlType(INT), AutoInc, PrimaryKey
   *  @param activityname Database column activityName SqlType(VARCHAR), Length(256,true)
   *  @param picpath Database column picPath SqlType(VARCHAR), Length(256,true)
   *  @param createtime Database column createTime SqlType(DATETIME)
   *  @param modifytime Database column modifyTime SqlType(DATETIME)
   *  @param rulecontent Database column ruleContent SqlType(VARCHAR), Length(255,true)
   *  @param activityurl Database column activityUrl SqlType(VARCHAR), Length(256,true)
   *  @param morepicpath Database column morePicPath SqlType(VARCHAR), Length(256,true)
   *  @param moreurl Database column moreUrl SqlType(VARCHAR), Length(256,true)
   *  @param status Database column status SqlType(INT), Default(0)
   *  @param outcolor Database column outColor SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param innercolor Database column innerColor SqlType(VARCHAR), Length(50,true), Default(None) */
  case class TBankaActivityRow(id: Int, activityname: String, picpath: String, createtime: java.sql.Timestamp, modifytime: java.sql.Timestamp, rulecontent: String, activityurl: String, morepicpath: String, moreurl: String, status: Int = 0, outcolor: Option[String] = None, innercolor: Option[String] = None)
  /** GetResult implicit for fetching TBankaActivityRow objects using plain SQL queries */
  implicit def GetResultTBankaActivityRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[TBankaActivityRow] = GR{
    prs => import prs._
    TBankaActivityRow.tupled((<<[Int], <<[String], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<[String], <<[String], <<[String], <<[Int], <<?[String], <<?[String]))
  }
  /** Table description of table T_BanKa_Activity. Objects of this class serve as prototypes for rows in queries. */
  class TBankaActivity(_tableTag: Tag) extends Table[TBankaActivityRow](_tableTag, "T_BanKa_Activity") {
    def * = (id, activityname, picpath, createtime, modifytime, rulecontent, activityurl, morepicpath, moreurl, status, outcolor, innercolor) <> (TBankaActivityRow.tupled, TBankaActivityRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(activityname), Rep.Some(picpath), Rep.Some(createtime), Rep.Some(modifytime), Rep.Some(rulecontent), Rep.Some(activityurl), Rep.Some(morepicpath), Rep.Some(moreurl), Rep.Some(status), outcolor, innercolor).shaped.<>({r=>import r._; _1.map(_=> TBankaActivityRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11, _12)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column activityName SqlType(VARCHAR), Length(256,true) */
    val activityname: Rep[String] = column[String]("activityName", O.Length(256,varying=true))
    /** Database column picPath SqlType(VARCHAR), Length(256,true) */
    val picpath: Rep[String] = column[String]("picPath", O.Length(256,varying=true))
    /** Database column createTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("createTime")
    /** Database column modifyTime SqlType(DATETIME) */
    val modifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modifyTime")
    /** Database column ruleContent SqlType(VARCHAR), Length(255,true) */
    val rulecontent: Rep[String] = column[String]("ruleContent", O.Length(255,varying=true))
    /** Database column activityUrl SqlType(VARCHAR), Length(256,true) */
    val activityurl: Rep[String] = column[String]("activityUrl", O.Length(256,varying=true))
    /** Database column morePicPath SqlType(VARCHAR), Length(256,true) */
    val morepicpath: Rep[String] = column[String]("morePicPath", O.Length(256,varying=true))
    /** Database column moreUrl SqlType(VARCHAR), Length(256,true) */
    val moreurl: Rep[String] = column[String]("moreUrl", O.Length(256,varying=true))
    /** Database column status SqlType(INT), Default(0) */
    val status: Rep[Int] = column[Int]("status", O.Default(0))
    /** Database column outColor SqlType(VARCHAR), Length(50,true), Default(None) */
    val outcolor: Rep[Option[String]] = column[Option[String]]("outColor", O.Length(50,varying=true), O.Default(None))
    /** Database column innerColor SqlType(VARCHAR), Length(50,true), Default(None) */
    val innercolor: Rep[Option[String]] = column[Option[String]]("innerColor", O.Length(50,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table TBankaActivity */
  lazy val TBankaActivity = new TableQuery(tag => new TBankaActivity(tag))

  /** Entity class storing rows of table TBankaCarddetails
   *  @param id Database column ID SqlType(INT), AutoInc, PrimaryKey
   *  @param activityid Database column activityId SqlType(INT)
   *  @param cardname Database column cardName SqlType(VARCHAR), Length(100,true)
   *  @param cardtag Database column cardTag SqlType(VARCHAR), Length(256,true) */
  case class TBankaCarddetailsRow(id: Int, activityid: Int, cardname: String, cardtag: String)
  /** GetResult implicit for fetching TBankaCarddetailsRow objects using plain SQL queries */
  implicit def GetResultTBankaCarddetailsRow(implicit e0: GR[Int], e1: GR[String]): GR[TBankaCarddetailsRow] = GR{
    prs => import prs._
    TBankaCarddetailsRow.tupled((<<[Int], <<[Int], <<[String], <<[String]))
  }
  /** Table description of table T_Banka_CardDetails. Objects of this class serve as prototypes for rows in queries. */
  class TBankaCarddetails(_tableTag: Tag) extends Table[TBankaCarddetailsRow](_tableTag, "T_Banka_CardDetails") {
    def * = (id, activityid, cardname, cardtag) <> (TBankaCarddetailsRow.tupled, TBankaCarddetailsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(activityid), Rep.Some(cardname), Rep.Some(cardtag)).shaped.<>({r=>import r._; _1.map(_=> TBankaCarddetailsRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column activityId SqlType(INT) */
    val activityid: Rep[Int] = column[Int]("activityId")
    /** Database column cardName SqlType(VARCHAR), Length(100,true) */
    val cardname: Rep[String] = column[String]("cardName", O.Length(100,varying=true))
    /** Database column cardTag SqlType(VARCHAR), Length(256,true) */
    val cardtag: Rep[String] = column[String]("cardTag", O.Length(256,varying=true))
  }
  /** Collection-like TableQuery object for table TBankaCarddetails */
  lazy val TBankaCarddetails = new TableQuery(tag => new TBankaCarddetails(tag))

  /** Row type of table TBanklimitconfig */
  type TBanklimitconfigRow = HCons[Long,HCons[Long,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[Int,HCons[Int,HCons[Int,HCons[Long,HCons[Long,HCons[Long,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[Option[Int],HCons[Int,HCons[Int,HCons[java.sql.Timestamp,HCons[java.sql.Timestamp,HCons[Int,HCons[Long,HNil]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for TBanklimitconfigRow providing default values if available in the database schema. */
  def TBanklimitconfigRow(autoid: Long, bankid: Long, code: String = "", simplename: String = "", name: String, fullname: String = "", bankcode: String = "", `type`: Int = 999, state: Int = 0, enterprise: Int = 0, firstlimit: Long = 0L, tradelimit: Long = 0L, daylimit: Long = 0L, prop: String = "", cardtype: String = "", scope: String = "", tldesc: String = "", dldesc: String = "", timespermonth: Option[Int] = None, channeltype: Int, status: Int = 0, createtime: java.sql.Timestamp, lastmodifytime: java.sql.Timestamp, rechargechannelconfig: Int = 0, rechargeminrateamount: Long = 0L): TBanklimitconfigRow = {
    autoid :: bankid :: code :: simplename :: name :: fullname :: bankcode :: `type` :: state :: enterprise :: firstlimit :: tradelimit :: daylimit :: prop :: cardtype :: scope :: tldesc :: dldesc :: timespermonth :: channeltype :: status :: createtime :: lastmodifytime :: rechargechannelconfig :: rechargeminrateamount :: HNil
  }
  /** GetResult implicit for fetching TBanklimitconfigRow objects using plain SQL queries */
  implicit def GetResultTBanklimitconfigRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[Option[Int]], e4: GR[java.sql.Timestamp]): GR[TBanklimitconfigRow] = GR{
    prs => import prs._
    <<[Long] :: <<[Long] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[Int] :: <<[Int] :: <<[Int] :: <<[Long] :: <<[Long] :: <<[Long] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<?[Int] :: <<[Int] :: <<[Int] :: <<[java.sql.Timestamp] :: <<[java.sql.Timestamp] :: <<[Int] :: <<[Long] :: HNil
  }
  /** Table description of table T_BankLimitConfig. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class TBanklimitconfig(_tableTag: Tag) extends Table[TBanklimitconfigRow](_tableTag, "T_BankLimitConfig") {
    def * = autoid :: bankid :: code :: simplename :: name :: fullname :: bankcode :: `type` :: state :: enterprise :: firstlimit :: tradelimit :: daylimit :: prop :: cardtype :: scope :: tldesc :: dldesc :: timespermonth :: channeltype :: status :: createtime :: lastmodifytime :: rechargechannelconfig :: rechargeminrateamount :: HNil

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column BankId SqlType(BIGINT) */
    val bankid: Rep[Long] = column[Long]("BankId")
    /** Database column Code SqlType(VARCHAR), Length(50,true), Default() */
    val code: Rep[String] = column[String]("Code", O.Length(50,varying=true), O.Default(""))
    /** Database column SimpleName SqlType(VARCHAR), Length(100,true), Default() */
    val simplename: Rep[String] = column[String]("SimpleName", O.Length(100,varying=true), O.Default(""))
    /** Database column Name SqlType(VARCHAR), Length(100,true) */
    val name: Rep[String] = column[String]("Name", O.Length(100,varying=true))
    /** Database column FullName SqlType(VARCHAR), Length(100,true), Default() */
    val fullname: Rep[String] = column[String]("FullName", O.Length(100,varying=true), O.Default(""))
    /** Database column BankCode SqlType(VARCHAR), Length(100,true), Default() */
    val bankcode: Rep[String] = column[String]("BankCode", O.Length(100,varying=true), O.Default(""))
    /** Database column Type SqlType(INT), Default(999)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Int] = column[Int]("Type", O.Default(999))
    /** Database column State SqlType(INT), Default(0) */
    val state: Rep[Int] = column[Int]("State", O.Default(0))
    /** Database column Enterprise SqlType(INT), Default(0) */
    val enterprise: Rep[Int] = column[Int]("Enterprise", O.Default(0))
    /** Database column FirstLimit SqlType(BIGINT), Default(0) */
    val firstlimit: Rep[Long] = column[Long]("FirstLimit", O.Default(0L))
    /** Database column TradeLimit SqlType(BIGINT), Default(0) */
    val tradelimit: Rep[Long] = column[Long]("TradeLimit", O.Default(0L))
    /** Database column DayLimit SqlType(BIGINT), Default(0) */
    val daylimit: Rep[Long] = column[Long]("DayLimit", O.Default(0L))
    /** Database column Prop SqlType(VARCHAR), Length(50,true), Default() */
    val prop: Rep[String] = column[String]("Prop", O.Length(50,varying=true), O.Default(""))
    /** Database column CardType SqlType(VARCHAR), Length(50,true), Default() */
    val cardtype: Rep[String] = column[String]("CardType", O.Length(50,varying=true), O.Default(""))
    /** Database column Scope SqlType(VARCHAR), Length(50,true), Default() */
    val scope: Rep[String] = column[String]("Scope", O.Length(50,varying=true), O.Default(""))
    /** Database column Tldesc SqlType(VARCHAR), Length(50,true), Default() */
    val tldesc: Rep[String] = column[String]("Tldesc", O.Length(50,varying=true), O.Default(""))
    /** Database column Dldesc SqlType(VARCHAR), Length(50,true), Default() */
    val dldesc: Rep[String] = column[String]("Dldesc", O.Length(50,varying=true), O.Default(""))
    /** Database column TimesPerMonth SqlType(INT), Default(None) */
    val timespermonth: Rep[Option[Int]] = column[Option[Int]]("TimesPerMonth", O.Default(None))
    /** Database column ChannelType SqlType(INT) */
    val channeltype: Rep[Int] = column[Int]("ChannelType")
    /** Database column Status SqlType(INT), Default(0) */
    val status: Rep[Int] = column[Int]("Status", O.Default(0))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column RechargeChannelConfig SqlType(INT), Default(0) */
    val rechargechannelconfig: Rep[Int] = column[Int]("RechargeChannelConfig", O.Default(0))
    /** Database column RechargeMinRateAmount SqlType(BIGINT), Default(0) */
    val rechargeminrateamount: Rep[Long] = column[Long]("RechargeMinRateAmount", O.Default(0L))
  }
  /** Collection-like TableQuery object for table TBanklimitconfig */
  lazy val TBanklimitconfig = new TableQuery(tag => new TBanklimitconfig(tag))

  /** Entity class storing rows of table TBankthirdtype
   *  @param id Database column ID SqlType(INT), AutoInc, PrimaryKey
   *  @param thirdname Database column ThirdName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param createtime Database column CreateTime SqlType(DATETIME), Default(None)
   *  @param lastmodifytime Database column LastModifyTime SqlType(DATETIME), Default(None) */
  case class TBankthirdtypeRow(id: Int, thirdname: Option[String] = None, createtime: Option[java.sql.Timestamp] = None, lastmodifytime: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching TBankthirdtypeRow objects using plain SQL queries */
  implicit def GetResultTBankthirdtypeRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[java.sql.Timestamp]]): GR[TBankthirdtypeRow] = GR{
    prs => import prs._
    TBankthirdtypeRow.tupled((<<[Int], <<?[String], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }
  /** Table description of table T_BankThirdType. Objects of this class serve as prototypes for rows in queries. */
  class TBankthirdtype(_tableTag: Tag) extends Table[TBankthirdtypeRow](_tableTag, "T_BankThirdType") {
    def * = (id, thirdname, createtime, lastmodifytime) <> (TBankthirdtypeRow.tupled, TBankthirdtypeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), thirdname, createtime, lastmodifytime).shaped.<>({r=>import r._; _1.map(_=> TBankthirdtypeRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column ThirdName SqlType(VARCHAR), Length(100,true), Default(None) */
    val thirdname: Rep[Option[String]] = column[Option[String]]("ThirdName", O.Length(100,varying=true), O.Default(None))
    /** Database column CreateTime SqlType(DATETIME), Default(None) */
    val createtime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("CreateTime", O.Default(None))
    /** Database column LastModifyTime SqlType(DATETIME), Default(None) */
    val lastmodifytime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("LastModifyTime", O.Default(None))
  }
  /** Collection-like TableQuery object for table TBankthirdtype */
  lazy val TBankthirdtype = new TableQuery(tag => new TBankthirdtype(tag))

  /** Entity class storing rows of table TBkarea
   *  @param areacode Database column AreaCode SqlType(VARCHAR), PrimaryKey, Length(45,true), Default()
   *  @param areaname Database column AreaName SqlType(VARCHAR), Length(100,true), Default() */
  case class TBkareaRow(areacode: String = "", areaname: String = "")
  /** GetResult implicit for fetching TBkareaRow objects using plain SQL queries */
  implicit def GetResultTBkareaRow(implicit e0: GR[String]): GR[TBkareaRow] = GR{
    prs => import prs._
    TBkareaRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table T_BkArea. Objects of this class serve as prototypes for rows in queries. */
  class TBkarea(_tableTag: Tag) extends Table[TBkareaRow](_tableTag, "T_BkArea") {
    def * = (areacode, areaname) <> (TBkareaRow.tupled, TBkareaRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(areacode), Rep.Some(areaname)).shaped.<>({r=>import r._; _1.map(_=> TBkareaRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AreaCode SqlType(VARCHAR), PrimaryKey, Length(45,true), Default() */
    val areacode: Rep[String] = column[String]("AreaCode", O.PrimaryKey, O.Length(45,varying=true), O.Default(""))
    /** Database column AreaName SqlType(VARCHAR), Length(100,true), Default() */
    val areaname: Rep[String] = column[String]("AreaName", O.Length(100,varying=true), O.Default(""))
  }
  /** Collection-like TableQuery object for table TBkarea */
  lazy val TBkarea = new TableQuery(tag => new TBkarea(tag))

  /** Entity class storing rows of table TBkattache
   *  @param attacheid Database column AttacheID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column UserID SqlType(BIGINT), Default(0)
   *  @param bankid Database column BankID SqlType(INT), Default(0)
   *  @param citycode Database column CityCode SqlType(VARCHAR), Length(50,true), Default()
   *  @param cityname Database column CityName SqlType(VARCHAR), Length(50,true), Default()
   *  @param truename Database column TrueName SqlType(VARCHAR), Length(255,true), Default()
   *  @param idcard Database column IdCard SqlType(VARCHAR), Length(255,true), Default()
   *  @param autoidcard Database column AutoIdCard SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param idcardpictureurl Database column IdCardPictureUrl SqlType(VARCHAR), Length(255,true), Default(‘’)
   *  @param mobile Database column Mobile SqlType(VARCHAR), Length(255,true), Default()
   *  @param headpictureurl Database column HeadPictureUrl SqlType(VARCHAR), Length(255,true), Default()
   *  @param workcardno Database column WorkCardNo SqlType(VARCHAR), Length(50,true), Default()
   *  @param workcardpictureurl Database column WorkCardPictureUrl SqlType(VARCHAR), Length(255,true), Default()
   *  @param status Database column Status SqlType(INT), Default(0)
   *  @param createtime Database column CreateTime SqlType(DATETIME)
   *  @param lastmodifytime Database column LastModifyTime SqlType(DATETIME)
   *  @param verifytime Database column VerifyTime SqlType(DATETIME)
   *  @param positivecount Database column PositiveCount SqlType(INT), Default(0)
   *  @param negativecount Database column NegativeCount SqlType(INT), Default(0)
   *  @param ordercount Database column OrderCount SqlType(INT), Default(0) */
  case class TBkattacheRow(attacheid: Long, userid: Long = 0L, bankid: Int = 0, citycode: String = "", cityname: String = "", truename: String = "", idcard: String = "", autoidcard: Option[String] = None, idcardpictureurl: String = "‘’", mobile: String = "", headpictureurl: String = "", workcardno: String = "", workcardpictureurl: String = "", status: Int = 0, createtime: java.sql.Timestamp, lastmodifytime: java.sql.Timestamp, verifytime: java.sql.Timestamp, positivecount: Int = 0, negativecount: Int = 0, ordercount: Int = 0)
  /** GetResult implicit for fetching TBkattacheRow objects using plain SQL queries */
  implicit def GetResultTBkattacheRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[String], e3: GR[Option[String]], e4: GR[java.sql.Timestamp]): GR[TBkattacheRow] = GR{
    prs => import prs._
    TBkattacheRow.tupled((<<[Long], <<[Long], <<[Int], <<[String], <<[String], <<[String], <<[String], <<?[String], <<[String], <<[String], <<[String], <<[String], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table T_BkAttache. Objects of this class serve as prototypes for rows in queries. */
  class TBkattache(_tableTag: Tag) extends Table[TBkattacheRow](_tableTag, "T_BkAttache") {
    def * = (attacheid, userid, bankid, citycode, cityname, truename, idcard, autoidcard, idcardpictureurl, mobile, headpictureurl, workcardno, workcardpictureurl, status, createtime, lastmodifytime, verifytime, positivecount, negativecount, ordercount) <> (TBkattacheRow.tupled, TBkattacheRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(attacheid), Rep.Some(userid), Rep.Some(bankid), Rep.Some(citycode), Rep.Some(cityname), Rep.Some(truename), Rep.Some(idcard), autoidcard, Rep.Some(idcardpictureurl), Rep.Some(mobile), Rep.Some(headpictureurl), Rep.Some(workcardno), Rep.Some(workcardpictureurl), Rep.Some(status), Rep.Some(createtime), Rep.Some(lastmodifytime), Rep.Some(verifytime), Rep.Some(positivecount), Rep.Some(negativecount), Rep.Some(ordercount)).shaped.<>({r=>import r._; _1.map(_=> TBkattacheRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get, _19.get, _20.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AttacheID SqlType(BIGINT), AutoInc, PrimaryKey */
    val attacheid: Rep[Long] = column[Long]("AttacheID", O.AutoInc, O.PrimaryKey)
    /** Database column UserID SqlType(BIGINT), Default(0) */
    val userid: Rep[Long] = column[Long]("UserID", O.Default(0L))
    /** Database column BankID SqlType(INT), Default(0) */
    val bankid: Rep[Int] = column[Int]("BankID", O.Default(0))
    /** Database column CityCode SqlType(VARCHAR), Length(50,true), Default() */
    val citycode: Rep[String] = column[String]("CityCode", O.Length(50,varying=true), O.Default(""))
    /** Database column CityName SqlType(VARCHAR), Length(50,true), Default() */
    val cityname: Rep[String] = column[String]("CityName", O.Length(50,varying=true), O.Default(""))
    /** Database column TrueName SqlType(VARCHAR), Length(255,true), Default() */
    val truename: Rep[String] = column[String]("TrueName", O.Length(255,varying=true), O.Default(""))
    /** Database column IdCard SqlType(VARCHAR), Length(255,true), Default() */
    val idcard: Rep[String] = column[String]("IdCard", O.Length(255,varying=true), O.Default(""))
    /** Database column AutoIdCard SqlType(VARCHAR), Length(255,true), Default(None) */
    val autoidcard: Rep[Option[String]] = column[Option[String]]("AutoIdCard", O.Length(255,varying=true), O.Default(None))
    /** Database column IdCardPictureUrl SqlType(VARCHAR), Length(255,true), Default(‘’) */
    val idcardpictureurl: Rep[String] = column[String]("IdCardPictureUrl", O.Length(255,varying=true), O.Default("‘’"))
    /** Database column Mobile SqlType(VARCHAR), Length(255,true), Default() */
    val mobile: Rep[String] = column[String]("Mobile", O.Length(255,varying=true), O.Default(""))
    /** Database column HeadPictureUrl SqlType(VARCHAR), Length(255,true), Default() */
    val headpictureurl: Rep[String] = column[String]("HeadPictureUrl", O.Length(255,varying=true), O.Default(""))
    /** Database column WorkCardNo SqlType(VARCHAR), Length(50,true), Default() */
    val workcardno: Rep[String] = column[String]("WorkCardNo", O.Length(50,varying=true), O.Default(""))
    /** Database column WorkCardPictureUrl SqlType(VARCHAR), Length(255,true), Default() */
    val workcardpictureurl: Rep[String] = column[String]("WorkCardPictureUrl", O.Length(255,varying=true), O.Default(""))
    /** Database column Status SqlType(INT), Default(0) */
    val status: Rep[Int] = column[Int]("Status", O.Default(0))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column VerifyTime SqlType(DATETIME) */
    val verifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("VerifyTime")
    /** Database column PositiveCount SqlType(INT), Default(0) */
    val positivecount: Rep[Int] = column[Int]("PositiveCount", O.Default(0))
    /** Database column NegativeCount SqlType(INT), Default(0) */
    val negativecount: Rep[Int] = column[Int]("NegativeCount", O.Default(0))
    /** Database column OrderCount SqlType(INT), Default(0) */
    val ordercount: Rep[Int] = column[Int]("OrderCount", O.Default(0))

    /** Uniqueness Index over (mobile) (database name Mobile_UNIQUE) */
    val index1 = index("Mobile_UNIQUE", mobile, unique=true)
    /** Index over (status,citycode,bankid) (database name Status_CityCode_BankID) */
    val index2 = index("Status_CityCode_BankID", (status, citycode, bankid))
    /** Index over (createtime) (database name idx_CreateTime) */
    val index3 = index("idx_CreateTime", createtime)
  }
  /** Collection-like TableQuery object for table TBkattache */
  lazy val TBkattache = new TableQuery(tag => new TBkattache(tag))

  /** Entity class storing rows of table TBkattacheBank
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param bankid Database column BankId SqlType(INT)
   *  @param bankname Database column BankName SqlType(VARCHAR), Length(45,true)
   *  @param isdelete Database column IsDelete SqlType(INT) */
  case class TBkattacheBankRow(autoid: Long, bankid: Int, bankname: String, isdelete: Int)
  /** GetResult implicit for fetching TBkattacheBankRow objects using plain SQL queries */
  implicit def GetResultTBkattacheBankRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[String]): GR[TBkattacheBankRow] = GR{
    prs => import prs._
    TBkattacheBankRow.tupled((<<[Long], <<[Int], <<[String], <<[Int]))
  }
  /** Table description of table T_BkAttache_Bank. Objects of this class serve as prototypes for rows in queries. */
  class TBkattacheBank(_tableTag: Tag) extends Table[TBkattacheBankRow](_tableTag, "T_BkAttache_Bank") {
    def * = (autoid, bankid, bankname, isdelete) <> (TBkattacheBankRow.tupled, TBkattacheBankRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(bankid), Rep.Some(bankname), Rep.Some(isdelete)).shaped.<>({r=>import r._; _1.map(_=> TBkattacheBankRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column BankId SqlType(INT) */
    val bankid: Rep[Int] = column[Int]("BankId")
    /** Database column BankName SqlType(VARCHAR), Length(45,true) */
    val bankname: Rep[String] = column[String]("BankName", O.Length(45,varying=true))
    /** Database column IsDelete SqlType(INT) */
    val isdelete: Rep[Int] = column[Int]("IsDelete")
  }
  /** Collection-like TableQuery object for table TBkattacheBank */
  lazy val TBkattacheBank = new TableQuery(tag => new TBkattacheBank(tag))

  /** Entity class storing rows of table TBkattacheChangeaccount
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column UserId SqlType(BIGINT)
   *  @param cfrom Database column CFrom SqlType(VARCHAR), Length(45,true)
   *  @param cto Database column CTo SqlType(VARCHAR), Length(45,true)
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TBkattacheChangeaccountRow(autoid: Long, userid: Long, cfrom: String, cto: String, createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TBkattacheChangeaccountRow objects using plain SQL queries */
  implicit def GetResultTBkattacheChangeaccountRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[TBkattacheChangeaccountRow] = GR{
    prs => import prs._
    TBkattacheChangeaccountRow.tupled((<<[Long], <<[Long], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_BkAttache_ChangeAccount. Objects of this class serve as prototypes for rows in queries. */
  class TBkattacheChangeaccount(_tableTag: Tag) extends Table[TBkattacheChangeaccountRow](_tableTag, "T_BkAttache_ChangeAccount") {
    def * = (autoid, userid, cfrom, cto, createtime) <> (TBkattacheChangeaccountRow.tupled, TBkattacheChangeaccountRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(userid), Rep.Some(cfrom), Rep.Some(cto), Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TBkattacheChangeaccountRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column UserId SqlType(BIGINT) */
    val userid: Rep[Long] = column[Long]("UserId")
    /** Database column CFrom SqlType(VARCHAR), Length(45,true) */
    val cfrom: Rep[String] = column[String]("CFrom", O.Length(45,varying=true))
    /** Database column CTo SqlType(VARCHAR), Length(45,true) */
    val cto: Rep[String] = column[String]("CTo", O.Length(45,varying=true))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TBkattacheChangeaccount */
  lazy val TBkattacheChangeaccount = new TableQuery(tag => new TBkattacheChangeaccount(tag))

  /** Entity class storing rows of table TBkattacheFeedback
   *  @param autoid Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column UserID SqlType(BIGINT)
   *  @param question Database column Question SqlType(VARCHAR), Length(1000,true)
   *  @param answer Database column Answer SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param whoanswer Database column WhoAnswer SqlType(BIGINT), Default(None)
   *  @param createtime Database column CreateTime SqlType(DATETIME)
   *  @param shouldpush Database column ShouldPush SqlType(TINYINT), Default(None)
   *  @param feedtype Database column FeedType SqlType(VARCHAR), Length(20,true) */
  case class TBkattacheFeedbackRow(autoid: Long, userid: Long, question: String, answer: Option[String] = None, whoanswer: Option[Long] = None, createtime: java.sql.Timestamp, shouldpush: Option[Byte] = None, feedtype: String)
  /** GetResult implicit for fetching TBkattacheFeedbackRow objects using plain SQL queries */
  implicit def GetResultTBkattacheFeedbackRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Option[String]], e3: GR[Option[Long]], e4: GR[java.sql.Timestamp], e5: GR[Option[Byte]]): GR[TBkattacheFeedbackRow] = GR{
    prs => import prs._
    TBkattacheFeedbackRow.tupled((<<[Long], <<[Long], <<[String], <<?[String], <<?[Long], <<[java.sql.Timestamp], <<?[Byte], <<[String]))
  }
  /** Table description of table T_BkAttache_FeedBack. Objects of this class serve as prototypes for rows in queries. */
  class TBkattacheFeedback(_tableTag: Tag) extends Table[TBkattacheFeedbackRow](_tableTag, "T_BkAttache_FeedBack") {
    def * = (autoid, userid, question, answer, whoanswer, createtime, shouldpush, feedtype) <> (TBkattacheFeedbackRow.tupled, TBkattacheFeedbackRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(userid), Rep.Some(question), answer, whoanswer, Rep.Some(createtime), shouldpush, Rep.Some(feedtype)).shaped.<>({r=>import r._; _1.map(_=> TBkattacheFeedbackRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6.get, _7, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoID", O.AutoInc, O.PrimaryKey)
    /** Database column UserID SqlType(BIGINT) */
    val userid: Rep[Long] = column[Long]("UserID")
    /** Database column Question SqlType(VARCHAR), Length(1000,true) */
    val question: Rep[String] = column[String]("Question", O.Length(1000,varying=true))
    /** Database column Answer SqlType(VARCHAR), Length(1000,true), Default(None) */
    val answer: Rep[Option[String]] = column[Option[String]]("Answer", O.Length(1000,varying=true), O.Default(None))
    /** Database column WhoAnswer SqlType(BIGINT), Default(None) */
    val whoanswer: Rep[Option[Long]] = column[Option[Long]]("WhoAnswer", O.Default(None))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column ShouldPush SqlType(TINYINT), Default(None) */
    val shouldpush: Rep[Option[Byte]] = column[Option[Byte]]("ShouldPush", O.Default(None))
    /** Database column FeedType SqlType(VARCHAR), Length(20,true) */
    val feedtype: Rep[String] = column[String]("FeedType", O.Length(20,varying=true))
  }
  /** Collection-like TableQuery object for table TBkattacheFeedback */
  lazy val TBkattacheFeedback = new TableQuery(tag => new TBkattacheFeedback(tag))

  /** Entity class storing rows of table TBkattacheInvite
   *  @param inviteid Database column InviteId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param appid Database column AppID SqlType(INT)
   *  @param attacheuserid Database column AttacheUserID SqlType(BIGINT)
   *  @param invitemobile Database column InviteMobile SqlType(VARCHAR), Length(255,true)
   *  @param status Database column Status SqlType(INT)
   *  @param createtime Database column CreateTime SqlType(DATETIME)
   *  @param registertime Database column RegisterTime SqlType(DATETIME), Default(None)
   *  @param registeruserid Database column RegisterUserID SqlType(BIGINT), Default(None) */
  case class TBkattacheInviteRow(inviteid: Long, appid: Int, attacheuserid: Long, invitemobile: String, status: Int, createtime: java.sql.Timestamp, registertime: Option[java.sql.Timestamp] = None, registeruserid: Option[Long] = None)
  /** GetResult implicit for fetching TBkattacheInviteRow objects using plain SQL queries */
  implicit def GetResultTBkattacheInviteRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[String], e3: GR[java.sql.Timestamp], e4: GR[Option[java.sql.Timestamp]], e5: GR[Option[Long]]): GR[TBkattacheInviteRow] = GR{
    prs => import prs._
    TBkattacheInviteRow.tupled((<<[Long], <<[Int], <<[Long], <<[String], <<[Int], <<[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[Long]))
  }
  /** Table description of table T_BkAttache_Invite. Objects of this class serve as prototypes for rows in queries. */
  class TBkattacheInvite(_tableTag: Tag) extends Table[TBkattacheInviteRow](_tableTag, "T_BkAttache_Invite") {
    def * = (inviteid, appid, attacheuserid, invitemobile, status, createtime, registertime, registeruserid) <> (TBkattacheInviteRow.tupled, TBkattacheInviteRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(inviteid), Rep.Some(appid), Rep.Some(attacheuserid), Rep.Some(invitemobile), Rep.Some(status), Rep.Some(createtime), registertime, registeruserid).shaped.<>({r=>import r._; _1.map(_=> TBkattacheInviteRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column InviteId SqlType(BIGINT), AutoInc, PrimaryKey */
    val inviteid: Rep[Long] = column[Long]("InviteId", O.AutoInc, O.PrimaryKey)
    /** Database column AppID SqlType(INT) */
    val appid: Rep[Int] = column[Int]("AppID")
    /** Database column AttacheUserID SqlType(BIGINT) */
    val attacheuserid: Rep[Long] = column[Long]("AttacheUserID")
    /** Database column InviteMobile SqlType(VARCHAR), Length(255,true) */
    val invitemobile: Rep[String] = column[String]("InviteMobile", O.Length(255,varying=true))
    /** Database column Status SqlType(INT) */
    val status: Rep[Int] = column[Int]("Status")
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column RegisterTime SqlType(DATETIME), Default(None) */
    val registertime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("RegisterTime", O.Default(None))
    /** Database column RegisterUserID SqlType(BIGINT), Default(None) */
    val registeruserid: Rep[Option[Long]] = column[Option[Long]]("RegisterUserID", O.Default(None))
  }
  /** Collection-like TableQuery object for table TBkattacheInvite */
  lazy val TBkattacheInvite = new TableQuery(tag => new TBkattacheInvite(tag))

  /** Entity class storing rows of table TBkattacheMb
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column UserId SqlType(BIGINT)
   *  @param mobile Database column Mobile SqlType(VARCHAR), Length(15,true)
   *  @param state Database column State SqlType(INT)
   *  @param isdefault Database column IsDefault SqlType(TINYINT)
   *  @param cttime Database column CTTime SqlType(DATETIME)
   *  @param mdtime Database column MDTime SqlType(DATETIME) */
  case class TBkattacheMbRow(autoid: Long, userid: Long, mobile: String, state: Int, isdefault: Byte, cttime: java.sql.Timestamp, mdtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TBkattacheMbRow objects using plain SQL queries */
  implicit def GetResultTBkattacheMbRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[Byte], e4: GR[java.sql.Timestamp]): GR[TBkattacheMbRow] = GR{
    prs => import prs._
    TBkattacheMbRow.tupled((<<[Long], <<[Long], <<[String], <<[Int], <<[Byte], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_BkAttache_Mb. Objects of this class serve as prototypes for rows in queries. */
  class TBkattacheMb(_tableTag: Tag) extends Table[TBkattacheMbRow](_tableTag, "T_BkAttache_Mb") {
    def * = (autoid, userid, mobile, state, isdefault, cttime, mdtime) <> (TBkattacheMbRow.tupled, TBkattacheMbRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(userid), Rep.Some(mobile), Rep.Some(state), Rep.Some(isdefault), Rep.Some(cttime), Rep.Some(mdtime)).shaped.<>({r=>import r._; _1.map(_=> TBkattacheMbRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column UserId SqlType(BIGINT) */
    val userid: Rep[Long] = column[Long]("UserId")
    /** Database column Mobile SqlType(VARCHAR), Length(15,true) */
    val mobile: Rep[String] = column[String]("Mobile", O.Length(15,varying=true))
    /** Database column State SqlType(INT) */
    val state: Rep[Int] = column[Int]("State")
    /** Database column IsDefault SqlType(TINYINT) */
    val isdefault: Rep[Byte] = column[Byte]("IsDefault")
    /** Database column CTTime SqlType(DATETIME) */
    val cttime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CTTime")
    /** Database column MDTime SqlType(DATETIME) */
    val mdtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("MDTime")
  }
  /** Collection-like TableQuery object for table TBkattacheMb */
  lazy val TBkattacheMb = new TableQuery(tag => new TBkattacheMb(tag))

  /** Entity class storing rows of table TBkattacheMerge
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param fromuserid Database column FromUserId SqlType(BIGINT)
   *  @param fmobile Database column FMobile SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param touserid Database column ToUserId SqlType(BIGINT)
   *  @param remark Database column Remark SqlType(VARCHAR), Length(1000,true)
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TBkattacheMergeRow(autoid: Long, fromuserid: Long, fmobile: Option[String] = None, touserid: Long, remark: String, createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TBkattacheMergeRow objects using plain SQL queries */
  implicit def GetResultTBkattacheMergeRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[String], e3: GR[java.sql.Timestamp]): GR[TBkattacheMergeRow] = GR{
    prs => import prs._
    TBkattacheMergeRow.tupled((<<[Long], <<[Long], <<?[String], <<[Long], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_BkAttache_Merge. Objects of this class serve as prototypes for rows in queries. */
  class TBkattacheMerge(_tableTag: Tag) extends Table[TBkattacheMergeRow](_tableTag, "T_BkAttache_Merge") {
    def * = (autoid, fromuserid, fmobile, touserid, remark, createtime) <> (TBkattacheMergeRow.tupled, TBkattacheMergeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(fromuserid), fmobile, Rep.Some(touserid), Rep.Some(remark), Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TBkattacheMergeRow.tupled((_1.get, _2.get, _3, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column FromUserId SqlType(BIGINT) */
    val fromuserid: Rep[Long] = column[Long]("FromUserId")
    /** Database column FMobile SqlType(VARCHAR), Length(45,true), Default(None) */
    val fmobile: Rep[Option[String]] = column[Option[String]]("FMobile", O.Length(45,varying=true), O.Default(None))
    /** Database column ToUserId SqlType(BIGINT) */
    val touserid: Rep[Long] = column[Long]("ToUserId")
    /** Database column Remark SqlType(VARCHAR), Length(1000,true) */
    val remark: Rep[String] = column[String]("Remark", O.Length(1000,varying=true))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TBkattacheMerge */
  lazy val TBkattacheMerge = new TableQuery(tag => new TBkattacheMerge(tag))

  /** Entity class storing rows of table TBkattachePw
   *  @param userid Database column UserId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param password Database column Password SqlType(VARCHAR), Length(45,true)
   *  @param mobile Database column Mobile SqlType(VARCHAR), Length(255,true)
   *  @param state Database column State SqlType(INT), Default(Some(1))
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TBkattachePwRow(userid: Long, password: String, mobile: String, state: Option[Int] = Some(1), createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TBkattachePwRow objects using plain SQL queries */
  implicit def GetResultTBkattachePwRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Option[Int]], e3: GR[java.sql.Timestamp]): GR[TBkattachePwRow] = GR{
    prs => import prs._
    TBkattachePwRow.tupled((<<[Long], <<[String], <<[String], <<?[Int], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_BkAttache_Pw. Objects of this class serve as prototypes for rows in queries. */
  class TBkattachePw(_tableTag: Tag) extends Table[TBkattachePwRow](_tableTag, "T_BkAttache_Pw") {
    def * = (userid, password, mobile, state, createtime) <> (TBkattachePwRow.tupled, TBkattachePwRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(userid), Rep.Some(password), Rep.Some(mobile), state, Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TBkattachePwRow.tupled((_1.get, _2.get, _3.get, _4, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column UserId SqlType(BIGINT), AutoInc, PrimaryKey */
    val userid: Rep[Long] = column[Long]("UserId", O.AutoInc, O.PrimaryKey)
    /** Database column Password SqlType(VARCHAR), Length(45,true) */
    val password: Rep[String] = column[String]("Password", O.Length(45,varying=true))
    /** Database column Mobile SqlType(VARCHAR), Length(255,true) */
    val mobile: Rep[String] = column[String]("Mobile", O.Length(255,varying=true))
    /** Database column State SqlType(INT), Default(Some(1)) */
    val state: Rep[Option[Int]] = column[Option[Int]]("State", O.Default(Some(1)))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TBkattachePw */
  lazy val TBkattachePw = new TableQuery(tag => new TBkattachePw(tag))

  /** Entity class storing rows of table TBkbank
   *  @param autoid Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param bankid Database column BankID SqlType(BIGINT), Default(0)
   *  @param bankname Database column BankName SqlType(VARCHAR), Length(50,true), Default()
   *  @param citycode Database column CityCode SqlType(VARCHAR), Length(50,true)
   *  @param cityname Database column CityName SqlType(VARCHAR), Length(50,true), Default()
   *  @param status Database column Status SqlType(INT), Default(0)
   *  @param daylimitcount Database column DayLimitCount SqlType(INT), Default(10)
   *  @param lastmodifytime Database column LastModifyTime SqlType(DATETIME)
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TBkbankRow(autoid: Long, bankid: Long = 0L, bankname: String = "", citycode: String, cityname: String = "", status: Int = 0, daylimitcount: Int = 10, lastmodifytime: java.sql.Timestamp, createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TBkbankRow objects using plain SQL queries */
  implicit def GetResultTBkbankRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[java.sql.Timestamp]): GR[TBkbankRow] = GR{
    prs => import prs._
    TBkbankRow.tupled((<<[Long], <<[Long], <<[String], <<[String], <<[String], <<[Int], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_BkBank. Objects of this class serve as prototypes for rows in queries. */
  class TBkbank(_tableTag: Tag) extends Table[TBkbankRow](_tableTag, "T_BkBank") {
    def * = (autoid, bankid, bankname, citycode, cityname, status, daylimitcount, lastmodifytime, createtime) <> (TBkbankRow.tupled, TBkbankRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(bankid), Rep.Some(bankname), Rep.Some(citycode), Rep.Some(cityname), Rep.Some(status), Rep.Some(daylimitcount), Rep.Some(lastmodifytime), Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TBkbankRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoID", O.AutoInc, O.PrimaryKey)
    /** Database column BankID SqlType(BIGINT), Default(0) */
    val bankid: Rep[Long] = column[Long]("BankID", O.Default(0L))
    /** Database column BankName SqlType(VARCHAR), Length(50,true), Default() */
    val bankname: Rep[String] = column[String]("BankName", O.Length(50,varying=true), O.Default(""))
    /** Database column CityCode SqlType(VARCHAR), Length(50,true) */
    val citycode: Rep[String] = column[String]("CityCode", O.Length(50,varying=true))
    /** Database column CityName SqlType(VARCHAR), Length(50,true), Default() */
    val cityname: Rep[String] = column[String]("CityName", O.Length(50,varying=true), O.Default(""))
    /** Database column Status SqlType(INT), Default(0) */
    val status: Rep[Int] = column[Int]("Status", O.Default(0))
    /** Database column DayLimitCount SqlType(INT), Default(10) */
    val daylimitcount: Rep[Int] = column[Int]("DayLimitCount", O.Default(10))
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TBkbank */
  lazy val TBkbank = new TableQuery(tag => new TBkbank(tag))

  /** Entity class storing rows of table TBkbankcards
   *  @param id Database column ID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param cardname Database column CardName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param cardpic Database column CardPic SqlType(VARCHAR), Length(300,true), Default(None)
   *  @param carddesc Database column CardDesc SqlType(VARCHAR), Length(500,true), Default(None)
   *  @param cardspecil Database column CardSpecil SqlType(INT), Default(None)
   *  @param cardlink Database column CardLink SqlType(VARCHAR), Length(300,true), Default(None)
   *  @param indexorder Database column IndexOrder SqlType(INT), Default(Some(0))
   *  @param bankname Database column BankName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param bankid Database column BankId SqlType(BIGINT), Default(None)
   *  @param status Database column Status SqlType(INT), Default(None)
   *  @param grades Database column Grades SqlType(INT), Default(None)
   *  @param types Database column Types SqlType(INT), Default(None)
   *  @param currency Database column Currency SqlType(INT), Default(None)
   *  @param recommend Database column Recommend SqlType(INT), Default(Some(0))
   *  @param hot Database column Hot SqlType(INT), Default(Some(0))
   *  @param thirdtype Database column ThirdType SqlType(INT), Default(Some(0))
   *  @param createtime Database column CreateTime SqlType(DATETIME), Default(None)
   *  @param updatetime Database column UpdateTime SqlType(DATETIME), Default(None)
   *  @param bankcardtag Database column BankCardTag SqlType(VARCHAR), Length(300,true), Default(Some()) */
  case class TBkbankcardsRow(id: Long, cardname: Option[String] = None, cardpic: Option[String] = None, carddesc: Option[String] = None, cardspecil: Option[Int] = None, cardlink: Option[String] = None, indexorder: Option[Int] = Some(0), bankname: Option[String] = None, bankid: Option[Long] = None, status: Option[Int] = None, grades: Option[Int] = None, types: Option[Int] = None, currency: Option[Int] = None, recommend: Option[Int] = Some(0), hot: Option[Int] = Some(0), thirdtype: Option[Int] = Some(0), createtime: Option[java.sql.Timestamp] = None, updatetime: Option[java.sql.Timestamp] = None, bankcardtag: Option[String] = Some(""))
  /** GetResult implicit for fetching TBkbankcardsRow objects using plain SQL queries */
  implicit def GetResultTBkbankcardsRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[Long]], e4: GR[Option[java.sql.Timestamp]]): GR[TBkbankcardsRow] = GR{
    prs => import prs._
    TBkbankcardsRow.tupled((<<[Long], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[String], <<?[Int], <<?[String], <<?[Long], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[String]))
  }
  /** Table description of table T_BKBankCards. Objects of this class serve as prototypes for rows in queries. */
  class TBkbankcards(_tableTag: Tag) extends Table[TBkbankcardsRow](_tableTag, "T_BKBankCards") {
    def * = (id, cardname, cardpic, carddesc, cardspecil, cardlink, indexorder, bankname, bankid, status, grades, types, currency, recommend, hot, thirdtype, createtime, updatetime, bankcardtag) <> (TBkbankcardsRow.tupled, TBkbankcardsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), cardname, cardpic, carddesc, cardspecil, cardlink, indexorder, bankname, bankid, status, grades, types, currency, recommend, hot, thirdtype, createtime, updatetime, bankcardtag).shaped.<>({r=>import r._; _1.map(_=> TBkbankcardsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column CardName SqlType(VARCHAR), Length(100,true), Default(None) */
    val cardname: Rep[Option[String]] = column[Option[String]]("CardName", O.Length(100,varying=true), O.Default(None))
    /** Database column CardPic SqlType(VARCHAR), Length(300,true), Default(None) */
    val cardpic: Rep[Option[String]] = column[Option[String]]("CardPic", O.Length(300,varying=true), O.Default(None))
    /** Database column CardDesc SqlType(VARCHAR), Length(500,true), Default(None) */
    val carddesc: Rep[Option[String]] = column[Option[String]]("CardDesc", O.Length(500,varying=true), O.Default(None))
    /** Database column CardSpecil SqlType(INT), Default(None) */
    val cardspecil: Rep[Option[Int]] = column[Option[Int]]("CardSpecil", O.Default(None))
    /** Database column CardLink SqlType(VARCHAR), Length(300,true), Default(None) */
    val cardlink: Rep[Option[String]] = column[Option[String]]("CardLink", O.Length(300,varying=true), O.Default(None))
    /** Database column IndexOrder SqlType(INT), Default(Some(0)) */
    val indexorder: Rep[Option[Int]] = column[Option[Int]]("IndexOrder", O.Default(Some(0)))
    /** Database column BankName SqlType(VARCHAR), Length(100,true), Default(None) */
    val bankname: Rep[Option[String]] = column[Option[String]]("BankName", O.Length(100,varying=true), O.Default(None))
    /** Database column BankId SqlType(BIGINT), Default(None) */
    val bankid: Rep[Option[Long]] = column[Option[Long]]("BankId", O.Default(None))
    /** Database column Status SqlType(INT), Default(None) */
    val status: Rep[Option[Int]] = column[Option[Int]]("Status", O.Default(None))
    /** Database column Grades SqlType(INT), Default(None) */
    val grades: Rep[Option[Int]] = column[Option[Int]]("Grades", O.Default(None))
    /** Database column Types SqlType(INT), Default(None) */
    val types: Rep[Option[Int]] = column[Option[Int]]("Types", O.Default(None))
    /** Database column Currency SqlType(INT), Default(None) */
    val currency: Rep[Option[Int]] = column[Option[Int]]("Currency", O.Default(None))
    /** Database column Recommend SqlType(INT), Default(Some(0)) */
    val recommend: Rep[Option[Int]] = column[Option[Int]]("Recommend", O.Default(Some(0)))
    /** Database column Hot SqlType(INT), Default(Some(0)) */
    val hot: Rep[Option[Int]] = column[Option[Int]]("Hot", O.Default(Some(0)))
    /** Database column ThirdType SqlType(INT), Default(Some(0)) */
    val thirdtype: Rep[Option[Int]] = column[Option[Int]]("ThirdType", O.Default(Some(0)))
    /** Database column CreateTime SqlType(DATETIME), Default(None) */
    val createtime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("CreateTime", O.Default(None))
    /** Database column UpdateTime SqlType(DATETIME), Default(None) */
    val updatetime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("UpdateTime", O.Default(None))
    /** Database column BankCardTag SqlType(VARCHAR), Length(300,true), Default(Some()) */
    val bankcardtag: Rep[Option[String]] = column[Option[String]]("BankCardTag", O.Length(300,varying=true), O.Default(Some("")))
  }
  /** Collection-like TableQuery object for table TBkbankcards */
  lazy val TBkbankcards = new TableQuery(tag => new TBkbankcards(tag))

  /** Entity class storing rows of table TBkbankcity
   *  @param autoid Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param bktype Database column BkType SqlType(BIGINT)
   *  @param bankid Database column BankID SqlType(BIGINT), Default(0)
   *  @param bankname Database column BankName SqlType(VARCHAR), Length(50,true), Default()
   *  @param citycode Database column CityCode SqlType(VARCHAR), Length(50,true)
   *  @param cityname Database column CityName SqlType(VARCHAR), Length(50,true), Default()
   *  @param status Database column Status SqlType(INT), Default(0)
   *  @param daylimitcount Database column DayLimitCount SqlType(INT), Default(0)
   *  @param lastmodifytime Database column LastModifyTime SqlType(DATETIME)
   *  @param createtime Database column CreateTime SqlType(DATETIME)
   *  @param quickurl Database column QuickUrl SqlType(VARCHAR), Length(255,true), Default()
   *  @param isregionbank Database column IsRegionBank SqlType(INT), Default(0) */
  case class TBkbankcityRow(autoid: Long, bktype: Long, bankid: Long = 0L, bankname: String = "", citycode: String, cityname: String = "", status: Int = 0, daylimitcount: Int = 0, lastmodifytime: java.sql.Timestamp, createtime: java.sql.Timestamp, quickurl: String = "", isregionbank: Int = 0)
  /** GetResult implicit for fetching TBkbankcityRow objects using plain SQL queries */
  implicit def GetResultTBkbankcityRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[java.sql.Timestamp]): GR[TBkbankcityRow] = GR{
    prs => import prs._
    TBkbankcityRow.tupled((<<[Long], <<[Long], <<[Long], <<[String], <<[String], <<[String], <<[Int], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<[Int]))
  }
  /** Table description of table T_BkBankCity. Objects of this class serve as prototypes for rows in queries. */
  class TBkbankcity(_tableTag: Tag) extends Table[TBkbankcityRow](_tableTag, "T_BkBankCity") {
    def * = (autoid, bktype, bankid, bankname, citycode, cityname, status, daylimitcount, lastmodifytime, createtime, quickurl, isregionbank) <> (TBkbankcityRow.tupled, TBkbankcityRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(bktype), Rep.Some(bankid), Rep.Some(bankname), Rep.Some(citycode), Rep.Some(cityname), Rep.Some(status), Rep.Some(daylimitcount), Rep.Some(lastmodifytime), Rep.Some(createtime), Rep.Some(quickurl), Rep.Some(isregionbank)).shaped.<>({r=>import r._; _1.map(_=> TBkbankcityRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoID", O.AutoInc, O.PrimaryKey)
    /** Database column BkType SqlType(BIGINT) */
    val bktype: Rep[Long] = column[Long]("BkType")
    /** Database column BankID SqlType(BIGINT), Default(0) */
    val bankid: Rep[Long] = column[Long]("BankID", O.Default(0L))
    /** Database column BankName SqlType(VARCHAR), Length(50,true), Default() */
    val bankname: Rep[String] = column[String]("BankName", O.Length(50,varying=true), O.Default(""))
    /** Database column CityCode SqlType(VARCHAR), Length(50,true) */
    val citycode: Rep[String] = column[String]("CityCode", O.Length(50,varying=true))
    /** Database column CityName SqlType(VARCHAR), Length(50,true), Default() */
    val cityname: Rep[String] = column[String]("CityName", O.Length(50,varying=true), O.Default(""))
    /** Database column Status SqlType(INT), Default(0) */
    val status: Rep[Int] = column[Int]("Status", O.Default(0))
    /** Database column DayLimitCount SqlType(INT), Default(0) */
    val daylimitcount: Rep[Int] = column[Int]("DayLimitCount", O.Default(0))
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column QuickUrl SqlType(VARCHAR), Length(255,true), Default() */
    val quickurl: Rep[String] = column[String]("QuickUrl", O.Length(255,varying=true), O.Default(""))
    /** Database column IsRegionBank SqlType(INT), Default(0) */
    val isregionbank: Rep[Int] = column[Int]("IsRegionBank", O.Default(0))
  }
  /** Collection-like TableQuery object for table TBkbankcity */
  lazy val TBkbankcity = new TableQuery(tag => new TBkbankcity(tag))

  /** Entity class storing rows of table TBkbankconfig
   *  @param autoid Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param bankid Database column BankID SqlType(BIGINT), Default(0)
   *  @param bankname Database column BankName SqlType(VARCHAR), Length(50,true), Default()
   *  @param quickurl Database column QuickUrl SqlType(VARCHAR), Length(256,true), Default()
   *  @param orderindex Database column OrderIndex SqlType(INT), Default(0)
   *  @param state Database column State SqlType(INT), Default(0)
   *  @param lastmodifytime Database column LastModifyTime SqlType(DATETIME)
   *  @param createtime Database column CreateTime SqlType(DATETIME)
   *  @param remark Database column Remark SqlType(VARCHAR), Length(255,true), Default()
   *  @param tag Database column Tag SqlType(VARCHAR), Length(255,true), Default()
   *  @param tagstate Database column TagState SqlType(TINYINT), Default(1) */
  case class TBkbankconfigRow(autoid: Long, bankid: Long = 0L, bankname: String = "", quickurl: String = "", orderindex: Int = 0, state: Int = 0, lastmodifytime: java.sql.Timestamp, createtime: java.sql.Timestamp, remark: String = "", tag: String = "", tagstate: Byte = 1)
  /** GetResult implicit for fetching TBkbankconfigRow objects using plain SQL queries */
  implicit def GetResultTBkbankconfigRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[java.sql.Timestamp], e4: GR[Byte]): GR[TBkbankconfigRow] = GR{
    prs => import prs._
    TBkbankconfigRow.tupled((<<[Long], <<[Long], <<[String], <<[String], <<[Int], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<[String], <<[Byte]))
  }
  /** Table description of table T_BkBankConfig. Objects of this class serve as prototypes for rows in queries. */
  class TBkbankconfig(_tableTag: Tag) extends Table[TBkbankconfigRow](_tableTag, "T_BkBankConfig") {
    def * = (autoid, bankid, bankname, quickurl, orderindex, state, lastmodifytime, createtime, remark, tag, tagstate) <> (TBkbankconfigRow.tupled, TBkbankconfigRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(bankid), Rep.Some(bankname), Rep.Some(quickurl), Rep.Some(orderindex), Rep.Some(state), Rep.Some(lastmodifytime), Rep.Some(createtime), Rep.Some(remark), Rep.Some(tag), Rep.Some(tagstate)).shaped.<>({r=>import r._; _1.map(_=> TBkbankconfigRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoID", O.AutoInc, O.PrimaryKey)
    /** Database column BankID SqlType(BIGINT), Default(0) */
    val bankid: Rep[Long] = column[Long]("BankID", O.Default(0L))
    /** Database column BankName SqlType(VARCHAR), Length(50,true), Default() */
    val bankname: Rep[String] = column[String]("BankName", O.Length(50,varying=true), O.Default(""))
    /** Database column QuickUrl SqlType(VARCHAR), Length(256,true), Default() */
    val quickurl: Rep[String] = column[String]("QuickUrl", O.Length(256,varying=true), O.Default(""))
    /** Database column OrderIndex SqlType(INT), Default(0) */
    val orderindex: Rep[Int] = column[Int]("OrderIndex", O.Default(0))
    /** Database column State SqlType(INT), Default(0) */
    val state: Rep[Int] = column[Int]("State", O.Default(0))
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column Remark SqlType(VARCHAR), Length(255,true), Default() */
    val remark: Rep[String] = column[String]("Remark", O.Length(255,varying=true), O.Default(""))
    /** Database column Tag SqlType(VARCHAR), Length(255,true), Default() */
    val tag: Rep[String] = column[String]("Tag", O.Length(255,varying=true), O.Default(""))
    /** Database column TagState SqlType(TINYINT), Default(1) */
    val tagstate: Rep[Byte] = column[Byte]("TagState", O.Default(1))
  }
  /** Collection-like TableQuery object for table TBkbankconfig */
  lazy val TBkbankconfig = new TableQuery(tag => new TBkbankconfig(tag))

  /** Entity class storing rows of table TBkbankthirdconfig
   *  @param autoid Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param bankid Database column BankID SqlType(BIGINT), Default(0)
   *  @param bankname Database column BankName SqlType(VARCHAR), Length(50,true), Default()
   *  @param quickurl Database column QuickUrl SqlType(VARCHAR), Length(256,true), Default()
   *  @param orderindex Database column OrderIndex SqlType(INT), Default(0)
   *  @param state Database column State SqlType(INT), Default(0)
   *  @param lastmodifytime Database column LastModifyTime SqlType(DATETIME)
   *  @param createtime Database column CreateTime SqlType(DATETIME)
   *  @param remark Database column Remark SqlType(VARCHAR), Length(255,true), Default()
   *  @param tag Database column Tag SqlType(VARCHAR), Length(255,true), Default()
   *  @param tagstate Database column TagState SqlType(TINYINT), Default(1)
   *  @param thirdtype Database column ThirdType SqlType(VARCHAR), Length(50,true), Default()
   *  @param showcity Database column ShowCity SqlType(VARCHAR), Length(512,true), Default() */
  case class TBkbankthirdconfigRow(autoid: Long, bankid: Long = 0L, bankname: String = "", quickurl: String = "", orderindex: Int = 0, state: Int = 0, lastmodifytime: java.sql.Timestamp, createtime: java.sql.Timestamp, remark: String = "", tag: String = "", tagstate: Byte = 1, thirdtype: String = "", showcity: String = "")
  /** GetResult implicit for fetching TBkbankthirdconfigRow objects using plain SQL queries */
  implicit def GetResultTBkbankthirdconfigRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[java.sql.Timestamp], e4: GR[Byte]): GR[TBkbankthirdconfigRow] = GR{
    prs => import prs._
    TBkbankthirdconfigRow.tupled((<<[Long], <<[Long], <<[String], <<[String], <<[Int], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<[String], <<[Byte], <<[String], <<[String]))
  }
  /** Table description of table T_BkBankThirdConfig. Objects of this class serve as prototypes for rows in queries. */
  class TBkbankthirdconfig(_tableTag: Tag) extends Table[TBkbankthirdconfigRow](_tableTag, "T_BkBankThirdConfig") {
    def * = (autoid, bankid, bankname, quickurl, orderindex, state, lastmodifytime, createtime, remark, tag, tagstate, thirdtype, showcity) <> (TBkbankthirdconfigRow.tupled, TBkbankthirdconfigRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(bankid), Rep.Some(bankname), Rep.Some(quickurl), Rep.Some(orderindex), Rep.Some(state), Rep.Some(lastmodifytime), Rep.Some(createtime), Rep.Some(remark), Rep.Some(tag), Rep.Some(tagstate), Rep.Some(thirdtype), Rep.Some(showcity)).shaped.<>({r=>import r._; _1.map(_=> TBkbankthirdconfigRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoID", O.AutoInc, O.PrimaryKey)
    /** Database column BankID SqlType(BIGINT), Default(0) */
    val bankid: Rep[Long] = column[Long]("BankID", O.Default(0L))
    /** Database column BankName SqlType(VARCHAR), Length(50,true), Default() */
    val bankname: Rep[String] = column[String]("BankName", O.Length(50,varying=true), O.Default(""))
    /** Database column QuickUrl SqlType(VARCHAR), Length(256,true), Default() */
    val quickurl: Rep[String] = column[String]("QuickUrl", O.Length(256,varying=true), O.Default(""))
    /** Database column OrderIndex SqlType(INT), Default(0) */
    val orderindex: Rep[Int] = column[Int]("OrderIndex", O.Default(0))
    /** Database column State SqlType(INT), Default(0) */
    val state: Rep[Int] = column[Int]("State", O.Default(0))
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column Remark SqlType(VARCHAR), Length(255,true), Default() */
    val remark: Rep[String] = column[String]("Remark", O.Length(255,varying=true), O.Default(""))
    /** Database column Tag SqlType(VARCHAR), Length(255,true), Default() */
    val tag: Rep[String] = column[String]("Tag", O.Length(255,varying=true), O.Default(""))
    /** Database column TagState SqlType(TINYINT), Default(1) */
    val tagstate: Rep[Byte] = column[Byte]("TagState", O.Default(1))
    /** Database column ThirdType SqlType(VARCHAR), Length(50,true), Default() */
    val thirdtype: Rep[String] = column[String]("ThirdType", O.Length(50,varying=true), O.Default(""))
    /** Database column ShowCity SqlType(VARCHAR), Length(512,true), Default() */
    val showcity: Rep[String] = column[String]("ShowCity", O.Length(512,varying=true), O.Default(""))
  }
  /** Collection-like TableQuery object for table TBkbankthirdconfig */
  lazy val TBkbankthirdconfig = new TableQuery(tag => new TBkbankthirdconfig(tag))

  /** Entity class storing rows of table TBkbanner
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param title Database column Title SqlType(VARCHAR), Length(255,true), Default()
   *  @param pictureurl Database column PictureUrl SqlType(VARCHAR), Length(255,true), Default()
   *  @param applyurl Database column ApplyUrl SqlType(VARCHAR), Length(255,true), Default()
   *  @param indexorder Database column IndexOrder SqlType(INT), Default(0)
   *  @param createtime Database column CreateTime SqlType(TIMESTAMP)
   *  @param lastmodifytime Database column LastModifyTime SqlType(TIMESTAMP)
   *  @param state Database column State SqlType(TINYINT), Default(1)
   *  @param showall Database column ShowAll SqlType(TINYINT), Default(0)
   *  @param showtype Database column ShowType SqlType(TINYINT), Default(0)
   *  @param bankid Database column BankId SqlType(INT), Default(0) */
  case class TBkbannerRow(autoid: Long, title: String = "", pictureurl: String = "", applyurl: String = "", indexorder: Int = 0, createtime: java.sql.Timestamp, lastmodifytime: java.sql.Timestamp, state: Byte = 1, showall: Byte = 0, showtype: Byte = 0, bankid: Int = 0)
  /** GetResult implicit for fetching TBkbannerRow objects using plain SQL queries */
  implicit def GetResultTBkbannerRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[java.sql.Timestamp], e4: GR[Byte]): GR[TBkbannerRow] = GR{
    prs => import prs._
    TBkbannerRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[Byte], <<[Byte], <<[Byte], <<[Int]))
  }
  /** Table description of table T_BkBanner. Objects of this class serve as prototypes for rows in queries. */
  class TBkbanner(_tableTag: Tag) extends Table[TBkbannerRow](_tableTag, "T_BkBanner") {
    def * = (autoid, title, pictureurl, applyurl, indexorder, createtime, lastmodifytime, state, showall, showtype, bankid) <> (TBkbannerRow.tupled, TBkbannerRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(title), Rep.Some(pictureurl), Rep.Some(applyurl), Rep.Some(indexorder), Rep.Some(createtime), Rep.Some(lastmodifytime), Rep.Some(state), Rep.Some(showall), Rep.Some(showtype), Rep.Some(bankid)).shaped.<>({r=>import r._; _1.map(_=> TBkbannerRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column Title SqlType(VARCHAR), Length(255,true), Default() */
    val title: Rep[String] = column[String]("Title", O.Length(255,varying=true), O.Default(""))
    /** Database column PictureUrl SqlType(VARCHAR), Length(255,true), Default() */
    val pictureurl: Rep[String] = column[String]("PictureUrl", O.Length(255,varying=true), O.Default(""))
    /** Database column ApplyUrl SqlType(VARCHAR), Length(255,true), Default() */
    val applyurl: Rep[String] = column[String]("ApplyUrl", O.Length(255,varying=true), O.Default(""))
    /** Database column IndexOrder SqlType(INT), Default(0) */
    val indexorder: Rep[Int] = column[Int]("IndexOrder", O.Default(0))
    /** Database column CreateTime SqlType(TIMESTAMP) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column LastModifyTime SqlType(TIMESTAMP) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column State SqlType(TINYINT), Default(1) */
    val state: Rep[Byte] = column[Byte]("State", O.Default(1))
    /** Database column ShowAll SqlType(TINYINT), Default(0) */
    val showall: Rep[Byte] = column[Byte]("ShowAll", O.Default(0))
    /** Database column ShowType SqlType(TINYINT), Default(0) */
    val showtype: Rep[Byte] = column[Byte]("ShowType", O.Default(0))
    /** Database column BankId SqlType(INT), Default(0) */
    val bankid: Rep[Int] = column[Int]("BankId", O.Default(0))
  }
  /** Collection-like TableQuery object for table TBkbanner */
  lazy val TBkbanner = new TableQuery(tag => new TBkbanner(tag))

  /** Row type of table TBkcardinfo */
  type TBkcardinfoRow = HCons[Long,HCons[String,HCons[String,HCons[Long,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[Int,HCons[String,HCons[String,HCons[String,HCons[String,HCons[java.sql.Timestamp,HCons[java.sql.Timestamp,HCons[Int,HCons[Int,HNil]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for TBkcardinfoRow providing default values if available in the database schema. */
  def TBkcardinfoRow(autoid: Long, cardname: String = "", bankname: String = "", bankid: Long = 0L, cityname: String = "", citycode: String = "", description: String = "", grade: String = "", freerule: String = "", annualfee: String = "", cashadvancelimit: String = "", creditcashfee: String = "", debitcashfee: String = "", minpayment: String = "", graceperiod: Int = 0, pointrule: String = "", pointvalidity: String = "", pictureurl: String = "", mark: String = "", createtime: java.sql.Timestamp, lastmodifytime: java.sql.Timestamp, orderindex: Int = 0, recommend: Int = 0): TBkcardinfoRow = {
    autoid :: cardname :: bankname :: bankid :: cityname :: citycode :: description :: grade :: freerule :: annualfee :: cashadvancelimit :: creditcashfee :: debitcashfee :: minpayment :: graceperiod :: pointrule :: pointvalidity :: pictureurl :: mark :: createtime :: lastmodifytime :: orderindex :: recommend :: HNil
  }
  /** GetResult implicit for fetching TBkcardinfoRow objects using plain SQL queries */
  implicit def GetResultTBkcardinfoRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[java.sql.Timestamp]): GR[TBkcardinfoRow] = GR{
    prs => import prs._
    <<[Long] :: <<[String] :: <<[String] :: <<[Long] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[Int] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[java.sql.Timestamp] :: <<[java.sql.Timestamp] :: <<[Int] :: <<[Int] :: HNil
  }
  /** Table description of table T_BkCardInfo. Objects of this class serve as prototypes for rows in queries. */
  class TBkcardinfo(_tableTag: Tag) extends Table[TBkcardinfoRow](_tableTag, "T_BkCardInfo") {
    def * = autoid :: cardname :: bankname :: bankid :: cityname :: citycode :: description :: grade :: freerule :: annualfee :: cashadvancelimit :: creditcashfee :: debitcashfee :: minpayment :: graceperiod :: pointrule :: pointvalidity :: pictureurl :: mark :: createtime :: lastmodifytime :: orderindex :: recommend :: HNil

    /** Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoID", O.AutoInc, O.PrimaryKey)
    /** Database column CardName SqlType(VARCHAR), Length(50,true), Default() */
    val cardname: Rep[String] = column[String]("CardName", O.Length(50,varying=true), O.Default(""))
    /** Database column BankName SqlType(VARCHAR), Length(50,true), Default() */
    val bankname: Rep[String] = column[String]("BankName", O.Length(50,varying=true), O.Default(""))
    /** Database column BankID SqlType(BIGINT), Default(0) */
    val bankid: Rep[Long] = column[Long]("BankID", O.Default(0L))
    /** Database column CityName SqlType(VARCHAR), Length(50,true), Default() */
    val cityname: Rep[String] = column[String]("CityName", O.Length(50,varying=true), O.Default(""))
    /** Database column CityCode SqlType(VARCHAR), Length(50,true), Default() */
    val citycode: Rep[String] = column[String]("CityCode", O.Length(50,varying=true), O.Default(""))
    /** Database column Description SqlType(VARCHAR), Length(1000,true), Default() */
    val description: Rep[String] = column[String]("Description", O.Length(1000,varying=true), O.Default(""))
    /** Database column Grade SqlType(VARCHAR), Length(50,true), Default() */
    val grade: Rep[String] = column[String]("Grade", O.Length(50,varying=true), O.Default(""))
    /** Database column FreeRule SqlType(VARCHAR), Length(100,true), Default() */
    val freerule: Rep[String] = column[String]("FreeRule", O.Length(100,varying=true), O.Default(""))
    /** Database column AnnualFee SqlType(VARCHAR), Length(100,true), Default() */
    val annualfee: Rep[String] = column[String]("AnnualFee", O.Length(100,varying=true), O.Default(""))
    /** Database column CashAdvanceLimit SqlType(VARCHAR), Length(100,true), Default() */
    val cashadvancelimit: Rep[String] = column[String]("CashAdvanceLimit", O.Length(100,varying=true), O.Default(""))
    /** Database column CreditCashFee SqlType(VARCHAR), Length(100,true), Default() */
    val creditcashfee: Rep[String] = column[String]("CreditCashFee", O.Length(100,varying=true), O.Default(""))
    /** Database column DebitCashFee SqlType(VARCHAR), Length(100,true), Default() */
    val debitcashfee: Rep[String] = column[String]("DebitCashFee", O.Length(100,varying=true), O.Default(""))
    /** Database column MinPayment SqlType(VARCHAR), Length(100,true), Default() */
    val minpayment: Rep[String] = column[String]("MinPayment", O.Length(100,varying=true), O.Default(""))
    /** Database column GracePeriod SqlType(INT), Default(0) */
    val graceperiod: Rep[Int] = column[Int]("GracePeriod", O.Default(0))
    /** Database column PointRule SqlType(VARCHAR), Length(100,true), Default() */
    val pointrule: Rep[String] = column[String]("PointRule", O.Length(100,varying=true), O.Default(""))
    /** Database column PointValidity SqlType(VARCHAR), Length(100,true), Default() */
    val pointvalidity: Rep[String] = column[String]("PointValidity", O.Length(100,varying=true), O.Default(""))
    /** Database column PictureUrl SqlType(VARCHAR), Length(256,true), Default() */
    val pictureurl: Rep[String] = column[String]("PictureUrl", O.Length(256,varying=true), O.Default(""))
    /** Database column Mark SqlType(VARCHAR), Length(200,true), Default() */
    val mark: Rep[String] = column[String]("Mark", O.Length(200,varying=true), O.Default(""))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column OrderIndex SqlType(INT), Default(0) */
    val orderindex: Rep[Int] = column[Int]("OrderIndex", O.Default(0))
    /** Database column Recommend SqlType(INT), Default(0) */
    val recommend: Rep[Int] = column[Int]("Recommend", O.Default(0))
  }
  /** Collection-like TableQuery object for table TBkcardinfo */
  lazy val TBkcardinfo = new TableQuery(tag => new TBkcardinfo(tag))

  /** Entity class storing rows of table TBkcharge
   *  @param chargeid Database column ChargeID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column UserID SqlType(BIGINT), Default(0)
   *  @param chargeamount Database column ChargeAmount SqlType(DECIMAL), Default(0.00)
   *  @param aboutids Database column AboutIDs SqlType(VARCHAR), Length(3000,true), Default()
   *  @param paystate Database column PayState SqlType(INT), Default(0)
   *  @param cardno Database column CardNo SqlType(VARCHAR), Length(255,true), Default()
   *  @param truename Database column TrueName SqlType(VARCHAR), Length(255,true), Default()
   *  @param cardaddress Database column CardAddress SqlType(VARCHAR), Length(100,true), Default()
   *  @param operatoruserid Database column OperatorUserID SqlType(BIGINT), Default(0)
   *  @param lastmodifytime Database column LastModifyTime SqlType(DATETIME)
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TBkchargeRow(chargeid: Long, userid: Long = 0L, chargeamount: scala.math.BigDecimal = 0.00d, aboutids: String = "", paystate: Int = 0, cardno: String = "", truename: String = "", cardaddress: String = "", operatoruserid: Long = 0L, lastmodifytime: java.sql.Timestamp, createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TBkchargeRow objects using plain SQL queries */
  implicit def GetResultTBkchargeRow(implicit e0: GR[Long], e1: GR[scala.math.BigDecimal], e2: GR[String], e3: GR[Int], e4: GR[java.sql.Timestamp]): GR[TBkchargeRow] = GR{
    prs => import prs._
    TBkchargeRow.tupled((<<[Long], <<[Long], <<[scala.math.BigDecimal], <<[String], <<[Int], <<[String], <<[String], <<[String], <<[Long], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_BkCharge. Objects of this class serve as prototypes for rows in queries. */
  class TBkcharge(_tableTag: Tag) extends Table[TBkchargeRow](_tableTag, "T_BkCharge") {
    def * = (chargeid, userid, chargeamount, aboutids, paystate, cardno, truename, cardaddress, operatoruserid, lastmodifytime, createtime) <> (TBkchargeRow.tupled, TBkchargeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(chargeid), Rep.Some(userid), Rep.Some(chargeamount), Rep.Some(aboutids), Rep.Some(paystate), Rep.Some(cardno), Rep.Some(truename), Rep.Some(cardaddress), Rep.Some(operatoruserid), Rep.Some(lastmodifytime), Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TBkchargeRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ChargeID SqlType(BIGINT), AutoInc, PrimaryKey */
    val chargeid: Rep[Long] = column[Long]("ChargeID", O.AutoInc, O.PrimaryKey)
    /** Database column UserID SqlType(BIGINT), Default(0) */
    val userid: Rep[Long] = column[Long]("UserID", O.Default(0L))
    /** Database column ChargeAmount SqlType(DECIMAL), Default(0.00) */
    val chargeamount: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("ChargeAmount", O.Default(0.00d))
    /** Database column AboutIDs SqlType(VARCHAR), Length(3000,true), Default() */
    val aboutids: Rep[String] = column[String]("AboutIDs", O.Length(3000,varying=true), O.Default(""))
    /** Database column PayState SqlType(INT), Default(0) */
    val paystate: Rep[Int] = column[Int]("PayState", O.Default(0))
    /** Database column CardNo SqlType(VARCHAR), Length(255,true), Default() */
    val cardno: Rep[String] = column[String]("CardNo", O.Length(255,varying=true), O.Default(""))
    /** Database column TrueName SqlType(VARCHAR), Length(255,true), Default() */
    val truename: Rep[String] = column[String]("TrueName", O.Length(255,varying=true), O.Default(""))
    /** Database column CardAddress SqlType(VARCHAR), Length(100,true), Default() */
    val cardaddress: Rep[String] = column[String]("CardAddress", O.Length(100,varying=true), O.Default(""))
    /** Database column OperatorUserID SqlType(BIGINT), Default(0) */
    val operatoruserid: Rep[Long] = column[Long]("OperatorUserID", O.Default(0L))
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TBkcharge */
  lazy val TBkcharge = new TableQuery(tag => new TBkcharge(tag))

  /** Entity class storing rows of table TBkchat
   *  @param autoid Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param `type` Database column Type SqlType(BIGINT), Default(0)
   *  @param usertype Database column UserType SqlType(INT), Default(0)
   *  @param orderid Database column OrderID SqlType(BIGINT), Default(0)
   *  @param userid Database column UserID SqlType(BIGINT), Default(0)
   *  @param message Database column Message SqlType(VARCHAR), Length(200,true), Default()
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TBkchatRow(autoid: Long, `type`: Long = 0L, usertype: Int = 0, orderid: Long = 0L, userid: Long = 0L, message: String = "", createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TBkchatRow objects using plain SQL queries */
  implicit def GetResultTBkchatRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[String], e3: GR[java.sql.Timestamp]): GR[TBkchatRow] = GR{
    prs => import prs._
    TBkchatRow.tupled((<<[Long], <<[Long], <<[Int], <<[Long], <<[Long], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_BkChat. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class TBkchat(_tableTag: Tag) extends Table[TBkchatRow](_tableTag, "T_BkChat") {
    def * = (autoid, `type`, usertype, orderid, userid, message, createtime) <> (TBkchatRow.tupled, TBkchatRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(`type`), Rep.Some(usertype), Rep.Some(orderid), Rep.Some(userid), Rep.Some(message), Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TBkchatRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoID", O.AutoInc, O.PrimaryKey)
    /** Database column Type SqlType(BIGINT), Default(0)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Long] = column[Long]("Type", O.Default(0L))
    /** Database column UserType SqlType(INT), Default(0) */
    val usertype: Rep[Int] = column[Int]("UserType", O.Default(0))
    /** Database column OrderID SqlType(BIGINT), Default(0) */
    val orderid: Rep[Long] = column[Long]("OrderID", O.Default(0L))
    /** Database column UserID SqlType(BIGINT), Default(0) */
    val userid: Rep[Long] = column[Long]("UserID", O.Default(0L))
    /** Database column Message SqlType(VARCHAR), Length(200,true), Default() */
    val message: Rep[String] = column[String]("Message", O.Length(200,varying=true), O.Default(""))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TBkchat */
  lazy val TBkchat = new TableQuery(tag => new TBkchat(tag))

  /** Entity class storing rows of table TBkchecklog
   *  @param autoid Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param attacheid Database column AttacheID SqlType(BIGINT), Default(0)
   *  @param attacheuserid Database column AttacheUserID SqlType(BIGINT), Default(0)
   *  @param checkremark Database column CheckRemark SqlType(VARCHAR), Length(500,true), Default()
   *  @param checktype Database column CheckType SqlType(VARCHAR), Length(50,true), Default()
   *  @param operatorid Database column OperatorID SqlType(BIGINT), Default(0)
   *  @param lastmodifytime Database column LastModifyTime SqlType(DATETIME)
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TBkchecklogRow(autoid: Long, attacheid: Long = 0L, attacheuserid: Long = 0L, checkremark: String = "", checktype: String = "", operatorid: Long = 0L, lastmodifytime: java.sql.Timestamp, createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TBkchecklogRow objects using plain SQL queries */
  implicit def GetResultTBkchecklogRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[TBkchecklogRow] = GR{
    prs => import prs._
    TBkchecklogRow.tupled((<<[Long], <<[Long], <<[Long], <<[String], <<[String], <<[Long], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_BkCheckLog. Objects of this class serve as prototypes for rows in queries. */
  class TBkchecklog(_tableTag: Tag) extends Table[TBkchecklogRow](_tableTag, "T_BkCheckLog") {
    def * = (autoid, attacheid, attacheuserid, checkremark, checktype, operatorid, lastmodifytime, createtime) <> (TBkchecklogRow.tupled, TBkchecklogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(attacheid), Rep.Some(attacheuserid), Rep.Some(checkremark), Rep.Some(checktype), Rep.Some(operatorid), Rep.Some(lastmodifytime), Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TBkchecklogRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoID", O.AutoInc, O.PrimaryKey)
    /** Database column AttacheID SqlType(BIGINT), Default(0) */
    val attacheid: Rep[Long] = column[Long]("AttacheID", O.Default(0L))
    /** Database column AttacheUserID SqlType(BIGINT), Default(0) */
    val attacheuserid: Rep[Long] = column[Long]("AttacheUserID", O.Default(0L))
    /** Database column CheckRemark SqlType(VARCHAR), Length(500,true), Default() */
    val checkremark: Rep[String] = column[String]("CheckRemark", O.Length(500,varying=true), O.Default(""))
    /** Database column CheckType SqlType(VARCHAR), Length(50,true), Default() */
    val checktype: Rep[String] = column[String]("CheckType", O.Length(50,varying=true), O.Default(""))
    /** Database column OperatorID SqlType(BIGINT), Default(0) */
    val operatorid: Rep[Long] = column[Long]("OperatorID", O.Default(0L))
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TBkchecklog */
  lazy val TBkchecklog = new TableQuery(tag => new TBkchecklog(tag))

  /** Entity class storing rows of table TBkdeviceuser
   *  @param autoid Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param appid Database column AppID SqlType(BIGINT), Default(0)
   *  @param plat Database column Plat SqlType(VARCHAR), Length(50,true), Default()
   *  @param macid Database column MacID SqlType(VARCHAR), Length(50,true), Default()
   *  @param udid Database column UdID SqlType(VARCHAR), Length(50,true), Default()
   *  @param selfid Database column SelfID SqlType(VARCHAR), Length(50,true), Default()
   *  @param userid Database column UserID SqlType(BIGINT), Default(0)
   *  @param devicetoken Database column DeviceToken SqlType(VARCHAR), Length(500,true), Default()
   *  @param platform Database column PlatForm SqlType(VARCHAR), Length(50,true), Default()
   *  @param lastmodifytime Database column LastModifyTime SqlType(DATETIME)
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TBkdeviceuserRow(autoid: Long, appid: Long = 0L, plat: String = "", macid: String = "", udid: String = "", selfid: String = "", userid: Long = 0L, devicetoken: String = "", platform: String = "", lastmodifytime: java.sql.Timestamp, createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TBkdeviceuserRow objects using plain SQL queries */
  implicit def GetResultTBkdeviceuserRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[TBkdeviceuserRow] = GR{
    prs => import prs._
    TBkdeviceuserRow.tupled((<<[Long], <<[Long], <<[String], <<[String], <<[String], <<[String], <<[Long], <<[String], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_BkDeviceUser. Objects of this class serve as prototypes for rows in queries. */
  class TBkdeviceuser(_tableTag: Tag) extends Table[TBkdeviceuserRow](_tableTag, "T_BkDeviceUser") {
    def * = (autoid, appid, plat, macid, udid, selfid, userid, devicetoken, platform, lastmodifytime, createtime) <> (TBkdeviceuserRow.tupled, TBkdeviceuserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(appid), Rep.Some(plat), Rep.Some(macid), Rep.Some(udid), Rep.Some(selfid), Rep.Some(userid), Rep.Some(devicetoken), Rep.Some(platform), Rep.Some(lastmodifytime), Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TBkdeviceuserRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoID", O.AutoInc, O.PrimaryKey)
    /** Database column AppID SqlType(BIGINT), Default(0) */
    val appid: Rep[Long] = column[Long]("AppID", O.Default(0L))
    /** Database column Plat SqlType(VARCHAR), Length(50,true), Default() */
    val plat: Rep[String] = column[String]("Plat", O.Length(50,varying=true), O.Default(""))
    /** Database column MacID SqlType(VARCHAR), Length(50,true), Default() */
    val macid: Rep[String] = column[String]("MacID", O.Length(50,varying=true), O.Default(""))
    /** Database column UdID SqlType(VARCHAR), Length(50,true), Default() */
    val udid: Rep[String] = column[String]("UdID", O.Length(50,varying=true), O.Default(""))
    /** Database column SelfID SqlType(VARCHAR), Length(50,true), Default() */
    val selfid: Rep[String] = column[String]("SelfID", O.Length(50,varying=true), O.Default(""))
    /** Database column UserID SqlType(BIGINT), Default(0) */
    val userid: Rep[Long] = column[Long]("UserID", O.Default(0L))
    /** Database column DeviceToken SqlType(VARCHAR), Length(500,true), Default() */
    val devicetoken: Rep[String] = column[String]("DeviceToken", O.Length(500,varying=true), O.Default(""))
    /** Database column PlatForm SqlType(VARCHAR), Length(50,true), Default() */
    val platform: Rep[String] = column[String]("PlatForm", O.Length(50,varying=true), O.Default(""))
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")

    /** Index over (appid,plat,macid) (database name MacID) */
    val index1 = index("MacID", (appid, plat, macid))
    /** Index over (appid,plat,udid) (database name UdID) */
    val index2 = index("UdID", (appid, plat, udid))
    /** Index over (userid) (database name idx_UserId) */
    val index3 = index("idx_UserId", userid)
  }
  /** Collection-like TableQuery object for table TBkdeviceuser */
  lazy val TBkdeviceuser = new TableQuery(tag => new TBkdeviceuser(tag))

  /** Row type of table TBkLandpage */
  type TBkLandpageRow = HCons[Long,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[java.sql.Timestamp,HCons[java.sql.Timestamp,HCons[java.sql.Timestamp,HCons[Boolean,HNil]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for TBkLandpageRow providing default values if available in the database schema. */
  def TBkLandpageRow(autoid: Long, title: String = "", discount: String = "", pictureurl: String = "", summary: String = "", activityurl: String = "", buriedpoint: String = "", titleofone: String = "", discountofone: String = "", pictureurlofone: String = "", summaryofone: String = "", activityurlofone: String = "", buriedpointofone: String = "", titleoftwo: String = "", discountoftwo: String = "", pictureurloftwo: String = "", summaryoftwo: String = "", activityurloftwo: String = "", buriedpointoftwo: String = "", moreactivityurl: String = "", buriedpointformore: String = "", operator: String = "", createtime: java.sql.Timestamp, endtime: java.sql.Timestamp, lastupdatetime: java.sql.Timestamp, status: Boolean = false): TBkLandpageRow = {
    autoid :: title :: discount :: pictureurl :: summary :: activityurl :: buriedpoint :: titleofone :: discountofone :: pictureurlofone :: summaryofone :: activityurlofone :: buriedpointofone :: titleoftwo :: discountoftwo :: pictureurloftwo :: summaryoftwo :: activityurloftwo :: buriedpointoftwo :: moreactivityurl :: buriedpointformore :: operator :: createtime :: endtime :: lastupdatetime :: status :: HNil
  }
  /** GetResult implicit for fetching TBkLandpageRow objects using plain SQL queries */
  implicit def GetResultTBkLandpageRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Boolean]): GR[TBkLandpageRow] = GR{
    prs => import prs._
    <<[Long] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[java.sql.Timestamp] :: <<[java.sql.Timestamp] :: <<[java.sql.Timestamp] :: <<[Boolean] :: HNil
  }
  /** Table description of table T_Bk_LandPage. Objects of this class serve as prototypes for rows in queries. */
  class TBkLandpage(_tableTag: Tag) extends Table[TBkLandpageRow](_tableTag, "T_Bk_LandPage") {
    def * = autoid :: title :: discount :: pictureurl :: summary :: activityurl :: buriedpoint :: titleofone :: discountofone :: pictureurlofone :: summaryofone :: activityurlofone :: buriedpointofone :: titleoftwo :: discountoftwo :: pictureurloftwo :: summaryoftwo :: activityurloftwo :: buriedpointoftwo :: moreactivityurl :: buriedpointformore :: operator :: createtime :: endtime :: lastupdatetime :: status :: HNil

    /** Database column Autoid SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("Autoid", O.AutoInc, O.PrimaryKey)
    /** Database column Title SqlType(VARCHAR), Length(255,true), Default() */
    val title: Rep[String] = column[String]("Title", O.Length(255,varying=true), O.Default(""))
    /** Database column Discount SqlType(VARCHAR), Length(255,true), Default() */
    val discount: Rep[String] = column[String]("Discount", O.Length(255,varying=true), O.Default(""))
    /** Database column PictureUrl SqlType(VARCHAR), Length(255,true), Default() */
    val pictureurl: Rep[String] = column[String]("PictureUrl", O.Length(255,varying=true), O.Default(""))
    /** Database column Summary SqlType(VARCHAR), Length(255,true), Default() */
    val summary: Rep[String] = column[String]("Summary", O.Length(255,varying=true), O.Default(""))
    /** Database column ActivityUrl SqlType(VARCHAR), Length(255,true), Default() */
    val activityurl: Rep[String] = column[String]("ActivityUrl", O.Length(255,varying=true), O.Default(""))
    /** Database column BuriedPoint SqlType(VARCHAR), Length(255,true), Default() */
    val buriedpoint: Rep[String] = column[String]("BuriedPoint", O.Length(255,varying=true), O.Default(""))
    /** Database column TitleOfOne SqlType(VARCHAR), Length(255,true), Default() */
    val titleofone: Rep[String] = column[String]("TitleOfOne", O.Length(255,varying=true), O.Default(""))
    /** Database column DiscountOfOne SqlType(VARCHAR), Length(255,true), Default() */
    val discountofone: Rep[String] = column[String]("DiscountOfOne", O.Length(255,varying=true), O.Default(""))
    /** Database column PictureUrlOfOne SqlType(VARCHAR), Length(255,true), Default() */
    val pictureurlofone: Rep[String] = column[String]("PictureUrlOfOne", O.Length(255,varying=true), O.Default(""))
    /** Database column SummaryOfOne SqlType(VARCHAR), Length(255,true), Default() */
    val summaryofone: Rep[String] = column[String]("SummaryOfOne", O.Length(255,varying=true), O.Default(""))
    /** Database column ActivityUrlOfOne SqlType(VARCHAR), Length(255,true), Default() */
    val activityurlofone: Rep[String] = column[String]("ActivityUrlOfOne", O.Length(255,varying=true), O.Default(""))
    /** Database column BuriedPointOfOne SqlType(VARCHAR), Length(255,true), Default() */
    val buriedpointofone: Rep[String] = column[String]("BuriedPointOfOne", O.Length(255,varying=true), O.Default(""))
    /** Database column TitleOfTwo SqlType(VARCHAR), Length(255,true), Default() */
    val titleoftwo: Rep[String] = column[String]("TitleOfTwo", O.Length(255,varying=true), O.Default(""))
    /** Database column DiscountOfTwo SqlType(VARCHAR), Length(255,true), Default() */
    val discountoftwo: Rep[String] = column[String]("DiscountOfTwo", O.Length(255,varying=true), O.Default(""))
    /** Database column PictureUrlOfTwo SqlType(VARCHAR), Length(255,true), Default() */
    val pictureurloftwo: Rep[String] = column[String]("PictureUrlOfTwo", O.Length(255,varying=true), O.Default(""))
    /** Database column SummaryOfTwo SqlType(VARCHAR), Length(255,true), Default() */
    val summaryoftwo: Rep[String] = column[String]("SummaryOfTwo", O.Length(255,varying=true), O.Default(""))
    /** Database column ActivityUrlOfTwo SqlType(VARCHAR), Length(255,true), Default() */
    val activityurloftwo: Rep[String] = column[String]("ActivityUrlOfTwo", O.Length(255,varying=true), O.Default(""))
    /** Database column BuriedPointOfTwo SqlType(VARCHAR), Length(255,true), Default() */
    val buriedpointoftwo: Rep[String] = column[String]("BuriedPointOfTwo", O.Length(255,varying=true), O.Default(""))
    /** Database column MoreActivityUrl SqlType(VARCHAR), Length(255,true), Default() */
    val moreactivityurl: Rep[String] = column[String]("MoreActivityUrl", O.Length(255,varying=true), O.Default(""))
    /** Database column BuriedPointForMore SqlType(VARCHAR), Length(255,true), Default() */
    val buriedpointformore: Rep[String] = column[String]("BuriedPointForMore", O.Length(255,varying=true), O.Default(""))
    /** Database column Operator SqlType(VARCHAR), Length(11,true), Default() */
    val operator: Rep[String] = column[String]("Operator", O.Length(11,varying=true), O.Default(""))
    /** Database column CreateTime SqlType(TIMESTAMP) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column EndTime SqlType(TIMESTAMP) */
    val endtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("EndTime")
    /** Database column LastUpdateTime SqlType(TIMESTAMP) */
    val lastupdatetime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastUpdateTime")
    /** Database column Status SqlType(BIT), Default(false) */
    val status: Rep[Boolean] = column[Boolean]("Status", O.Default(false))
  }
  /** Collection-like TableQuery object for table TBkLandpage */
  lazy val TBkLandpage = new TableQuery(tag => new TBkLandpage(tag))

  /** Entity class storing rows of table TBkmessage
   *  @param msgId Database column MSG_ID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param msgTitle Database column MSG_TITLE SqlType(VARCHAR), Length(200,true), Default()
   *  @param msgContent Database column MSG_CONTENT SqlType(VARCHAR), Length(2000,true), Default()
   *  @param msgUrl Database column MSG_URL SqlType(VARCHAR), Length(500,true), Default(None)
   *  @param msgStatus Database column MSG_STATUS SqlType(INT), Default(0)
   *  @param indexOrder Database column INDEX_ORDER SqlType(INT), Default(0)
   *  @param resType Database column RES_TYPE SqlType(VARCHAR), Length(500,true), Default(None)
   *  @param showAll Database column SHOW_ALL SqlType(INT), Default(0)
   *  @param startTime Database column START_TIME SqlType(DATETIME), Default(None)
   *  @param endTime Database column END_TIME SqlType(DATETIME), Default(None)
   *  @param createTime Database column CREATE_TIME SqlType(DATETIME)
   *  @param lastmodifyTime Database column LASTMODIFY_TIME SqlType(DATETIME) */
  case class TBkmessageRow(msgId: Long, msgTitle: String = "", msgContent: String = "", msgUrl: Option[String] = None, msgStatus: Int = 0, indexOrder: Int = 0, resType: Option[String] = None, showAll: Int = 0, startTime: Option[java.sql.Timestamp] = None, endTime: Option[java.sql.Timestamp] = None, createTime: java.sql.Timestamp, lastmodifyTime: java.sql.Timestamp)
  /** GetResult implicit for fetching TBkmessageRow objects using plain SQL queries */
  implicit def GetResultTBkmessageRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Option[String]], e3: GR[Int], e4: GR[Option[java.sql.Timestamp]], e5: GR[java.sql.Timestamp]): GR[TBkmessageRow] = GR{
    prs => import prs._
    TBkmessageRow.tupled((<<[Long], <<[String], <<[String], <<?[String], <<[Int], <<[Int], <<?[String], <<[Int], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_BkMessage. Objects of this class serve as prototypes for rows in queries. */
  class TBkmessage(_tableTag: Tag) extends Table[TBkmessageRow](_tableTag, "T_BkMessage") {
    def * = (msgId, msgTitle, msgContent, msgUrl, msgStatus, indexOrder, resType, showAll, startTime, endTime, createTime, lastmodifyTime) <> (TBkmessageRow.tupled, TBkmessageRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(msgId), Rep.Some(msgTitle), Rep.Some(msgContent), msgUrl, Rep.Some(msgStatus), Rep.Some(indexOrder), resType, Rep.Some(showAll), startTime, endTime, Rep.Some(createTime), Rep.Some(lastmodifyTime)).shaped.<>({r=>import r._; _1.map(_=> TBkmessageRow.tupled((_1.get, _2.get, _3.get, _4, _5.get, _6.get, _7, _8.get, _9, _10, _11.get, _12.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column MSG_ID SqlType(BIGINT), AutoInc, PrimaryKey */
    val msgId: Rep[Long] = column[Long]("MSG_ID", O.AutoInc, O.PrimaryKey)
    /** Database column MSG_TITLE SqlType(VARCHAR), Length(200,true), Default() */
    val msgTitle: Rep[String] = column[String]("MSG_TITLE", O.Length(200,varying=true), O.Default(""))
    /** Database column MSG_CONTENT SqlType(VARCHAR), Length(2000,true), Default() */
    val msgContent: Rep[String] = column[String]("MSG_CONTENT", O.Length(2000,varying=true), O.Default(""))
    /** Database column MSG_URL SqlType(VARCHAR), Length(500,true), Default(None) */
    val msgUrl: Rep[Option[String]] = column[Option[String]]("MSG_URL", O.Length(500,varying=true), O.Default(None))
    /** Database column MSG_STATUS SqlType(INT), Default(0) */
    val msgStatus: Rep[Int] = column[Int]("MSG_STATUS", O.Default(0))
    /** Database column INDEX_ORDER SqlType(INT), Default(0) */
    val indexOrder: Rep[Int] = column[Int]("INDEX_ORDER", O.Default(0))
    /** Database column RES_TYPE SqlType(VARCHAR), Length(500,true), Default(None) */
    val resType: Rep[Option[String]] = column[Option[String]]("RES_TYPE", O.Length(500,varying=true), O.Default(None))
    /** Database column SHOW_ALL SqlType(INT), Default(0) */
    val showAll: Rep[Int] = column[Int]("SHOW_ALL", O.Default(0))
    /** Database column START_TIME SqlType(DATETIME), Default(None) */
    val startTime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("START_TIME", O.Default(None))
    /** Database column END_TIME SqlType(DATETIME), Default(None) */
    val endTime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("END_TIME", O.Default(None))
    /** Database column CREATE_TIME SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_TIME")
    /** Database column LASTMODIFY_TIME SqlType(DATETIME) */
    val lastmodifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LASTMODIFY_TIME")
  }
  /** Collection-like TableQuery object for table TBkmessage */
  lazy val TBkmessage = new TableQuery(tag => new TBkmessage(tag))

  /** Row type of table TBkorder */
  type TBkorderRow = HCons[Long,HCons[Long,HCons[String,HCons[String,HCons[Long,HCons[Long,HCons[String,HCons[String,HCons[String,HCons[String,HCons[Int,HCons[Long,HCons[Long,HCons[Int,HCons[java.sql.Timestamp,HCons[java.sql.Timestamp,HCons[Int,HCons[String,HCons[Int,HCons[Int,HCons[String,HCons[String,HCons[scala.math.BigDecimal,HCons[scala.math.BigDecimal,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[Long,HCons[String,HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for TBkorderRow providing default values if available in the database schema. */
  def TBkorderRow(orderid: Long, tradeid: Long = 0L, citycode: String = "", areacode: String = "", userid: Long = 0L, bankid: Long = 0L, truename: String = "", address: String = "", mobile: String = "", remark: String = "", isurgent: Int = 0, attacheuserid: Long = 0L, attacheid: Long = 0L, state: Int = 0, createtime: java.sql.Timestamp, lastmodifytime: java.sql.Timestamp, appraise: Int = 0, reason: String = "", messagecount: Int = 0, usermessagecount: Int = 0, lastmessage: String = "", lastusermessage: String = "", lat: scala.math.BigDecimal = 0.000000000d, lon: scala.math.BigDecimal = 0.000000000d, cancelremark: String = "", cardgrade: String = "", occupation: String = "", fund: String = "", yearlyincome: String = "", userlabel: Long = 0L, channel: String = "", idcard: Option[String] = None, jobtype: Option[String] = None, company: Option[String] = None, socialensure: Option[String] = None, jobprove: Option[String] = None, graduation: Option[String] = None): TBkorderRow = {
    orderid :: tradeid :: citycode :: areacode :: userid :: bankid :: truename :: address :: mobile :: remark :: isurgent :: attacheuserid :: attacheid :: state :: createtime :: lastmodifytime :: appraise :: reason :: messagecount :: usermessagecount :: lastmessage :: lastusermessage :: lat :: lon :: cancelremark :: cardgrade :: occupation :: fund :: yearlyincome :: userlabel :: channel :: idcard :: jobtype :: company :: socialensure :: jobprove :: graduation :: HNil
  }
  /** GetResult implicit for fetching TBkorderRow objects using plain SQL queries */
  implicit def GetResultTBkorderRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[java.sql.Timestamp], e4: GR[scala.math.BigDecimal], e5: GR[Option[String]]): GR[TBkorderRow] = GR{
    prs => import prs._
    <<[Long] :: <<[Long] :: <<[String] :: <<[String] :: <<[Long] :: <<[Long] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[Int] :: <<[Long] :: <<[Long] :: <<[Int] :: <<[java.sql.Timestamp] :: <<[java.sql.Timestamp] :: <<[Int] :: <<[String] :: <<[Int] :: <<[Int] :: <<[String] :: <<[String] :: <<[scala.math.BigDecimal] :: <<[scala.math.BigDecimal] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[Long] :: <<[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: HNil
  }
  /** Table description of table T_BkOrder. Objects of this class serve as prototypes for rows in queries. */
  class TBkorder(_tableTag: Tag) extends Table[TBkorderRow](_tableTag, "T_BkOrder") {
    def * = orderid :: tradeid :: citycode :: areacode :: userid :: bankid :: truename :: address :: mobile :: remark :: isurgent :: attacheuserid :: attacheid :: state :: createtime :: lastmodifytime :: appraise :: reason :: messagecount :: usermessagecount :: lastmessage :: lastusermessage :: lat :: lon :: cancelremark :: cardgrade :: occupation :: fund :: yearlyincome :: userlabel :: channel :: idcard :: jobtype :: company :: socialensure :: jobprove :: graduation :: HNil

    /** Database column OrderID SqlType(BIGINT), AutoInc, PrimaryKey */
    val orderid: Rep[Long] = column[Long]("OrderID", O.AutoInc, O.PrimaryKey)
    /** Database column TradeID SqlType(BIGINT), Default(0) */
    val tradeid: Rep[Long] = column[Long]("TradeID", O.Default(0L))
    /** Database column CityCode SqlType(VARCHAR), Length(50,true), Default() */
    val citycode: Rep[String] = column[String]("CityCode", O.Length(50,varying=true), O.Default(""))
    /** Database column AreaCode SqlType(VARCHAR), Length(50,true), Default() */
    val areacode: Rep[String] = column[String]("AreaCode", O.Length(50,varying=true), O.Default(""))
    /** Database column UserID SqlType(BIGINT), Default(0) */
    val userid: Rep[Long] = column[Long]("UserID", O.Default(0L))
    /** Database column BankID SqlType(BIGINT), Default(0) */
    val bankid: Rep[Long] = column[Long]("BankID", O.Default(0L))
    /** Database column TrueName SqlType(VARCHAR), Length(255,true), Default() */
    val truename: Rep[String] = column[String]("TrueName", O.Length(255,varying=true), O.Default(""))
    /** Database column Address SqlType(VARCHAR), Length(200,true), Default() */
    val address: Rep[String] = column[String]("Address", O.Length(200,varying=true), O.Default(""))
    /** Database column Mobile SqlType(VARCHAR), Length(255,true), Default() */
    val mobile: Rep[String] = column[String]("Mobile", O.Length(255,varying=true), O.Default(""))
    /** Database column Remark SqlType(VARCHAR), Length(500,true), Default() */
    val remark: Rep[String] = column[String]("Remark", O.Length(500,varying=true), O.Default(""))
    /** Database column IsUrgent SqlType(INT), Default(0) */
    val isurgent: Rep[Int] = column[Int]("IsUrgent", O.Default(0))
    /** Database column AttacheUserID SqlType(BIGINT), Default(0) */
    val attacheuserid: Rep[Long] = column[Long]("AttacheUserID", O.Default(0L))
    /** Database column AttacheID SqlType(BIGINT), Default(0) */
    val attacheid: Rep[Long] = column[Long]("AttacheID", O.Default(0L))
    /** Database column State SqlType(INT), Default(0) */
    val state: Rep[Int] = column[Int]("State", O.Default(0))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column Appraise SqlType(INT), Default(0) */
    val appraise: Rep[Int] = column[Int]("Appraise", O.Default(0))
    /** Database column Reason SqlType(VARCHAR), Length(200,true), Default() */
    val reason: Rep[String] = column[String]("Reason", O.Length(200,varying=true), O.Default(""))
    /** Database column MessageCount SqlType(INT), Default(0) */
    val messagecount: Rep[Int] = column[Int]("MessageCount", O.Default(0))
    /** Database column UserMessageCount SqlType(INT), Default(0) */
    val usermessagecount: Rep[Int] = column[Int]("UserMessageCount", O.Default(0))
    /** Database column LastMessage SqlType(VARCHAR), Length(200,true), Default() */
    val lastmessage: Rep[String] = column[String]("LastMessage", O.Length(200,varying=true), O.Default(""))
    /** Database column LastUserMessage SqlType(VARCHAR), Length(200,true), Default() */
    val lastusermessage: Rep[String] = column[String]("LastUserMessage", O.Length(200,varying=true), O.Default(""))
    /** Database column Lat SqlType(DECIMAL), Default(0.000000000) */
    val lat: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("Lat", O.Default(0.000000000d))
    /** Database column Lon SqlType(DECIMAL), Default(0.000000000) */
    val lon: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("Lon", O.Default(0.000000000d))
    /** Database column CancelRemark SqlType(VARCHAR), Length(200,true), Default() */
    val cancelremark: Rep[String] = column[String]("CancelRemark", O.Length(200,varying=true), O.Default(""))
    /** Database column CardGrade SqlType(VARCHAR), Length(50,true), Default() */
    val cardgrade: Rep[String] = column[String]("CardGrade", O.Length(50,varying=true), O.Default(""))
    /** Database column Occupation SqlType(VARCHAR), Length(50,true), Default() */
    val occupation: Rep[String] = column[String]("Occupation", O.Length(50,varying=true), O.Default(""))
    /** Database column Fund SqlType(VARCHAR), Length(200,true), Default() */
    val fund: Rep[String] = column[String]("Fund", O.Length(200,varying=true), O.Default(""))
    /** Database column YearlyIncome SqlType(VARCHAR), Length(50,true), Default() */
    val yearlyincome: Rep[String] = column[String]("YearlyIncome", O.Length(50,varying=true), O.Default(""))
    /** Database column UserLabel SqlType(BIGINT), Default(0) */
    val userlabel: Rep[Long] = column[Long]("UserLabel", O.Default(0L))
    /** Database column Channel SqlType(VARCHAR), Length(50,true), Default() */
    val channel: Rep[String] = column[String]("Channel", O.Length(50,varying=true), O.Default(""))
    /** Database column IdCard SqlType(VARCHAR), Length(255,true), Default(None) */
    val idcard: Rep[Option[String]] = column[Option[String]]("IdCard", O.Length(255,varying=true), O.Default(None))
    /** Database column JobType SqlType(VARCHAR), Length(45,true), Default(None) */
    val jobtype: Rep[Option[String]] = column[Option[String]]("JobType", O.Length(45,varying=true), O.Default(None))
    /** Database column Company SqlType(VARCHAR), Length(45,true), Default(None) */
    val company: Rep[Option[String]] = column[Option[String]]("Company", O.Length(45,varying=true), O.Default(None))
    /** Database column SocialEnsure SqlType(VARCHAR), Length(45,true), Default(None) */
    val socialensure: Rep[Option[String]] = column[Option[String]]("SocialEnsure", O.Length(45,varying=true), O.Default(None))
    /** Database column JobProve SqlType(VARCHAR), Length(45,true), Default(None) */
    val jobprove: Rep[Option[String]] = column[Option[String]]("JobProve", O.Length(45,varying=true), O.Default(None))
    /** Database column Graduation SqlType(VARCHAR), Length(45,true), Default(None) */
    val graduation: Rep[Option[String]] = column[Option[String]]("Graduation", O.Length(45,varying=true), O.Default(None))

    /** Index over (attacheuserid,state) (database name AttacheUserID_State) */
    val index1 = index("AttacheUserID_State", attacheuserid :: state :: HNil)
    /** Index over (userid,orderid) (database name UserID_OrderID) */
    val index2 = index("UserID_OrderID", userid :: orderid :: HNil)
    /** Index over (state) (database name idx_State) */
    val index3 = index("idx_State", state :: HNil)
  }
  /** Collection-like TableQuery object for table TBkorder */
  lazy val TBkorder = new TableQuery(tag => new TBkorder(tag))

  /** Entity class storing rows of table TBkoutuser
   *  @param autoid Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userfrom Database column UserFrom SqlType(INT), Default(0)
   *  @param outloginkey Database column OutLoginKey SqlType(VARCHAR), Length(100,true), Default()
   *  @param outuserid Database column OutUserID SqlType(BIGINT), Default(0)
   *  @param userid Database column UserID SqlType(BIGINT), Default(0)
   *  @param createtime Database column CreateTime SqlType(DATETIME)
   *  @param lastmodifytime Database column LastModifyTime SqlType(DATETIME) */
  case class TBkoutuserRow(autoid: Long, userfrom: Int = 0, outloginkey: String = "", outuserid: Long = 0L, userid: Long = 0L, createtime: java.sql.Timestamp, lastmodifytime: java.sql.Timestamp)
  /** GetResult implicit for fetching TBkoutuserRow objects using plain SQL queries */
  implicit def GetResultTBkoutuserRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[String], e3: GR[java.sql.Timestamp]): GR[TBkoutuserRow] = GR{
    prs => import prs._
    TBkoutuserRow.tupled((<<[Long], <<[Int], <<[String], <<[Long], <<[Long], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_BkOutUser. Objects of this class serve as prototypes for rows in queries. */
  class TBkoutuser(_tableTag: Tag) extends Table[TBkoutuserRow](_tableTag, "T_BkOutUser") {
    def * = (autoid, userfrom, outloginkey, outuserid, userid, createtime, lastmodifytime) <> (TBkoutuserRow.tupled, TBkoutuserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(userfrom), Rep.Some(outloginkey), Rep.Some(outuserid), Rep.Some(userid), Rep.Some(createtime), Rep.Some(lastmodifytime)).shaped.<>({r=>import r._; _1.map(_=> TBkoutuserRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoID", O.AutoInc, O.PrimaryKey)
    /** Database column UserFrom SqlType(INT), Default(0) */
    val userfrom: Rep[Int] = column[Int]("UserFrom", O.Default(0))
    /** Database column OutLoginKey SqlType(VARCHAR), Length(100,true), Default() */
    val outloginkey: Rep[String] = column[String]("OutLoginKey", O.Length(100,varying=true), O.Default(""))
    /** Database column OutUserID SqlType(BIGINT), Default(0) */
    val outuserid: Rep[Long] = column[Long]("OutUserID", O.Default(0L))
    /** Database column UserID SqlType(BIGINT), Default(0) */
    val userid: Rep[Long] = column[Long]("UserID", O.Default(0L))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
  }
  /** Collection-like TableQuery object for table TBkoutuser */
  lazy val TBkoutuser = new TableQuery(tag => new TBkoutuser(tag))

  /** Entity class storing rows of table TBkprocess
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column UserId SqlType(BIGINT), Default(None)
   *  @param username Database column UserName SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param bankid Database column BankId SqlType(INT)
   *  @param idcard Database column IdCard SqlType(VARCHAR), Length(255,true)
   *  @param mobile Database column Mobile SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param result Database column Result SqlType(VARCHAR), Length(300,true), Default(None)
   *  @param channel Database column Channel SqlType(VARCHAR), Length(45,true)
   *  @param fguid Database column FGuid SqlType(VARCHAR), Length(55,true), Default(None)
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TBkprocessRow(autoid: Long, userid: Option[Long] = None, username: Option[String] = None, bankid: Int, idcard: String, mobile: Option[String] = None, result: Option[String] = None, channel: String, fguid: Option[String] = None, createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TBkprocessRow objects using plain SQL queries */
  implicit def GetResultTBkprocessRow(implicit e0: GR[Long], e1: GR[Option[Long]], e2: GR[Option[String]], e3: GR[Int], e4: GR[String], e5: GR[java.sql.Timestamp]): GR[TBkprocessRow] = GR{
    prs => import prs._
    TBkprocessRow.tupled((<<[Long], <<?[Long], <<?[String], <<[Int], <<[String], <<?[String], <<?[String], <<[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_BKProcess. Objects of this class serve as prototypes for rows in queries. */
  class TBkprocess(_tableTag: Tag) extends Table[TBkprocessRow](_tableTag, "T_BKProcess") {
    def * = (autoid, userid, username, bankid, idcard, mobile, result, channel, fguid, createtime) <> (TBkprocessRow.tupled, TBkprocessRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), userid, username, Rep.Some(bankid), Rep.Some(idcard), mobile, result, Rep.Some(channel), fguid, Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TBkprocessRow.tupled((_1.get, _2, _3, _4.get, _5.get, _6, _7, _8.get, _9, _10.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column UserId SqlType(BIGINT), Default(None) */
    val userid: Rep[Option[Long]] = column[Option[Long]]("UserId", O.Default(None))
    /** Database column UserName SqlType(VARCHAR), Length(255,true), Default(None) */
    val username: Rep[Option[String]] = column[Option[String]]("UserName", O.Length(255,varying=true), O.Default(None))
    /** Database column BankId SqlType(INT) */
    val bankid: Rep[Int] = column[Int]("BankId")
    /** Database column IdCard SqlType(VARCHAR), Length(255,true) */
    val idcard: Rep[String] = column[String]("IdCard", O.Length(255,varying=true))
    /** Database column Mobile SqlType(VARCHAR), Length(255,true), Default(None) */
    val mobile: Rep[Option[String]] = column[Option[String]]("Mobile", O.Length(255,varying=true), O.Default(None))
    /** Database column Result SqlType(VARCHAR), Length(300,true), Default(None) */
    val result: Rep[Option[String]] = column[Option[String]]("Result", O.Length(300,varying=true), O.Default(None))
    /** Database column Channel SqlType(VARCHAR), Length(45,true) */
    val channel: Rep[String] = column[String]("Channel", O.Length(45,varying=true))
    /** Database column FGuid SqlType(VARCHAR), Length(55,true), Default(None) */
    val fguid: Rep[Option[String]] = column[Option[String]]("FGuid", O.Length(55,varying=true), O.Default(None))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TBkprocess */
  lazy val TBkprocess = new TableQuery(tag => new TBkprocess(tag))

  /** Entity class storing rows of table TBkpromotion
   *  @param autoid Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column UserID SqlType(BIGINT), Default(0)
   *  @param email Database column Email SqlType(VARCHAR), Length(255,true), Default()
   *  @param mobile Database column Mobile SqlType(VARCHAR), Length(255,true), Default()
   *  @param truename Database column TrueName SqlType(VARCHAR), Length(255,true), Default()
   *  @param price Database column Price SqlType(DECIMAL), Default(0.00)
   *  @param state Database column State SqlType(INT), Default(0)
   *  @param statechangetime Database column StateChangeTime SqlType(DATETIME)
   *  @param matchuserid Database column MatchUserID SqlType(BIGINT), Default(0)
   *  @param chargeid Database column ChargeID SqlType(INT), Default(0)
   *  @param chargetime Database column ChargeTime SqlType(DATETIME)
   *  @param lastmodifytime Database column LastModifyTime SqlType(DATETIME)
   *  @param createtime Database column CreateTime SqlType(DATETIME)
   *  @param ip Database column IP SqlType(VARCHAR), Length(50,true), Default()
   *  @param ipaddress Database column IPAddress SqlType(VARCHAR), Length(100,true), Default()
   *  @param citycode Database column CityCode SqlType(VARCHAR), Length(50,true), Default()
   *  @param cityname Database column CityName SqlType(VARCHAR), Length(50,true), Default() */
  case class TBkpromotionRow(autoid: Long, userid: Long = 0L, email: String = "", mobile: String = "", truename: String = "", price: scala.math.BigDecimal = 0.00d, state: Int = 0, statechangetime: java.sql.Timestamp, matchuserid: Long = 0L, chargeid: Int = 0, chargetime: java.sql.Timestamp, lastmodifytime: java.sql.Timestamp, createtime: java.sql.Timestamp, ip: String = "", ipaddress: String = "", citycode: String = "", cityname: String = "")
  /** GetResult implicit for fetching TBkpromotionRow objects using plain SQL queries */
  implicit def GetResultTBkpromotionRow(implicit e0: GR[Long], e1: GR[String], e2: GR[scala.math.BigDecimal], e3: GR[Int], e4: GR[java.sql.Timestamp]): GR[TBkpromotionRow] = GR{
    prs => import prs._
    TBkpromotionRow.tupled((<<[Long], <<[Long], <<[String], <<[String], <<[String], <<[scala.math.BigDecimal], <<[Int], <<[java.sql.Timestamp], <<[Long], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<[String], <<[String], <<[String]))
  }
  /** Table description of table T_BkPromotion. Objects of this class serve as prototypes for rows in queries. */
  class TBkpromotion(_tableTag: Tag) extends Table[TBkpromotionRow](_tableTag, "T_BkPromotion") {
    def * = (autoid, userid, email, mobile, truename, price, state, statechangetime, matchuserid, chargeid, chargetime, lastmodifytime, createtime, ip, ipaddress, citycode, cityname) <> (TBkpromotionRow.tupled, TBkpromotionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(userid), Rep.Some(email), Rep.Some(mobile), Rep.Some(truename), Rep.Some(price), Rep.Some(state), Rep.Some(statechangetime), Rep.Some(matchuserid), Rep.Some(chargeid), Rep.Some(chargetime), Rep.Some(lastmodifytime), Rep.Some(createtime), Rep.Some(ip), Rep.Some(ipaddress), Rep.Some(citycode), Rep.Some(cityname)).shaped.<>({r=>import r._; _1.map(_=> TBkpromotionRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoID", O.AutoInc, O.PrimaryKey)
    /** Database column UserID SqlType(BIGINT), Default(0) */
    val userid: Rep[Long] = column[Long]("UserID", O.Default(0L))
    /** Database column Email SqlType(VARCHAR), Length(255,true), Default() */
    val email: Rep[String] = column[String]("Email", O.Length(255,varying=true), O.Default(""))
    /** Database column Mobile SqlType(VARCHAR), Length(255,true), Default() */
    val mobile: Rep[String] = column[String]("Mobile", O.Length(255,varying=true), O.Default(""))
    /** Database column TrueName SqlType(VARCHAR), Length(255,true), Default() */
    val truename: Rep[String] = column[String]("TrueName", O.Length(255,varying=true), O.Default(""))
    /** Database column Price SqlType(DECIMAL), Default(0.00) */
    val price: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("Price", O.Default(0.00d))
    /** Database column State SqlType(INT), Default(0) */
    val state: Rep[Int] = column[Int]("State", O.Default(0))
    /** Database column StateChangeTime SqlType(DATETIME) */
    val statechangetime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("StateChangeTime")
    /** Database column MatchUserID SqlType(BIGINT), Default(0) */
    val matchuserid: Rep[Long] = column[Long]("MatchUserID", O.Default(0L))
    /** Database column ChargeID SqlType(INT), Default(0) */
    val chargeid: Rep[Int] = column[Int]("ChargeID", O.Default(0))
    /** Database column ChargeTime SqlType(DATETIME) */
    val chargetime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("ChargeTime")
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column IP SqlType(VARCHAR), Length(50,true), Default() */
    val ip: Rep[String] = column[String]("IP", O.Length(50,varying=true), O.Default(""))
    /** Database column IPAddress SqlType(VARCHAR), Length(100,true), Default() */
    val ipaddress: Rep[String] = column[String]("IPAddress", O.Length(100,varying=true), O.Default(""))
    /** Database column CityCode SqlType(VARCHAR), Length(50,true), Default() */
    val citycode: Rep[String] = column[String]("CityCode", O.Length(50,varying=true), O.Default(""))
    /** Database column CityName SqlType(VARCHAR), Length(50,true), Default() */
    val cityname: Rep[String] = column[String]("CityName", O.Length(50,varying=true), O.Default(""))
  }
  /** Collection-like TableQuery object for table TBkpromotion */
  lazy val TBkpromotion = new TableQuery(tag => new TBkpromotion(tag))

  /** Entity class storing rows of table TBkstat
   *  @param autoid Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param statdate Database column StatDate SqlType(DATETIME)
   *  @param bankid Database column BankID SqlType(BIGINT), Default(0)
   *  @param bankname Database column BankName SqlType(VARCHAR), Length(50,true), Default()
   *  @param citycode Database column CityCode SqlType(VARCHAR), Length(50,true), Default()
   *  @param cityname Database column CityName SqlType(VARCHAR), Length(50,true), Default()
   *  @param attachecount Database column AttacheCount SqlType(INT), Default(0)
   *  @param waitingcount Database column WaitingCount SqlType(INT), Default(0)
   *  @param waitingcounttoday Database column WaitingCountToday SqlType(INT), Default(0)
   *  @param waitingcountyesterday Database column WaitingCountYesterday SqlType(INT), Default(0)
   *  @param waitiingcountbefore Database column WaitiingCountBefore SqlType(INT), Default(0)
   *  @param orderingcount Database column OrderingCount SqlType(INT), Default(0)
   *  @param orderingcounttoday Database column OrderingCountToday SqlType(INT), Default(0)
   *  @param orderingcountyesterday Database column OrderingCountYesterday SqlType(INT), Default(0)
   *  @param orderingcountbefore Database column OrderingCountBefore SqlType(INT), Default(0)
   *  @param completecount Database column CompleteCount SqlType(INT), Default(0)
   *  @param cancelbyuser Database column CancelByUser SqlType(INT), Default(0)
   *  @param cancelbyattache Database column CancelByAttache SqlType(INT), Default(0)
   *  @param cancelbysys Database column CancelBySys SqlType(INT), Default(0)
   *  @param lastmodifytime Database column LastModifyTime SqlType(DATETIME)
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TBkstatRow(autoid: Long, statdate: java.sql.Timestamp, bankid: Long = 0L, bankname: String = "", citycode: String = "", cityname: String = "", attachecount: Int = 0, waitingcount: Int = 0, waitingcounttoday: Int = 0, waitingcountyesterday: Int = 0, waitiingcountbefore: Int = 0, orderingcount: Int = 0, orderingcounttoday: Int = 0, orderingcountyesterday: Int = 0, orderingcountbefore: Int = 0, completecount: Int = 0, cancelbyuser: Int = 0, cancelbyattache: Int = 0, cancelbysys: Int = 0, lastmodifytime: java.sql.Timestamp, createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TBkstatRow objects using plain SQL queries */
  implicit def GetResultTBkstatRow(implicit e0: GR[Long], e1: GR[java.sql.Timestamp], e2: GR[String], e3: GR[Int]): GR[TBkstatRow] = GR{
    prs => import prs._
    TBkstatRow.tupled((<<[Long], <<[java.sql.Timestamp], <<[Long], <<[String], <<[String], <<[String], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_BkStat. Objects of this class serve as prototypes for rows in queries. */
  class TBkstat(_tableTag: Tag) extends Table[TBkstatRow](_tableTag, "T_BkStat") {
    def * = (autoid, statdate, bankid, bankname, citycode, cityname, attachecount, waitingcount, waitingcounttoday, waitingcountyesterday, waitiingcountbefore, orderingcount, orderingcounttoday, orderingcountyesterday, orderingcountbefore, completecount, cancelbyuser, cancelbyattache, cancelbysys, lastmodifytime, createtime) <> (TBkstatRow.tupled, TBkstatRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(statdate), Rep.Some(bankid), Rep.Some(bankname), Rep.Some(citycode), Rep.Some(cityname), Rep.Some(attachecount), Rep.Some(waitingcount), Rep.Some(waitingcounttoday), Rep.Some(waitingcountyesterday), Rep.Some(waitiingcountbefore), Rep.Some(orderingcount), Rep.Some(orderingcounttoday), Rep.Some(orderingcountyesterday), Rep.Some(orderingcountbefore), Rep.Some(completecount), Rep.Some(cancelbyuser), Rep.Some(cancelbyattache), Rep.Some(cancelbysys), Rep.Some(lastmodifytime), Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TBkstatRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get, _19.get, _20.get, _21.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoID", O.AutoInc, O.PrimaryKey)
    /** Database column StatDate SqlType(DATETIME) */
    val statdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("StatDate")
    /** Database column BankID SqlType(BIGINT), Default(0) */
    val bankid: Rep[Long] = column[Long]("BankID", O.Default(0L))
    /** Database column BankName SqlType(VARCHAR), Length(50,true), Default() */
    val bankname: Rep[String] = column[String]("BankName", O.Length(50,varying=true), O.Default(""))
    /** Database column CityCode SqlType(VARCHAR), Length(50,true), Default() */
    val citycode: Rep[String] = column[String]("CityCode", O.Length(50,varying=true), O.Default(""))
    /** Database column CityName SqlType(VARCHAR), Length(50,true), Default() */
    val cityname: Rep[String] = column[String]("CityName", O.Length(50,varying=true), O.Default(""))
    /** Database column AttacheCount SqlType(INT), Default(0) */
    val attachecount: Rep[Int] = column[Int]("AttacheCount", O.Default(0))
    /** Database column WaitingCount SqlType(INT), Default(0) */
    val waitingcount: Rep[Int] = column[Int]("WaitingCount", O.Default(0))
    /** Database column WaitingCountToday SqlType(INT), Default(0) */
    val waitingcounttoday: Rep[Int] = column[Int]("WaitingCountToday", O.Default(0))
    /** Database column WaitingCountYesterday SqlType(INT), Default(0) */
    val waitingcountyesterday: Rep[Int] = column[Int]("WaitingCountYesterday", O.Default(0))
    /** Database column WaitiingCountBefore SqlType(INT), Default(0) */
    val waitiingcountbefore: Rep[Int] = column[Int]("WaitiingCountBefore", O.Default(0))
    /** Database column OrderingCount SqlType(INT), Default(0) */
    val orderingcount: Rep[Int] = column[Int]("OrderingCount", O.Default(0))
    /** Database column OrderingCountToday SqlType(INT), Default(0) */
    val orderingcounttoday: Rep[Int] = column[Int]("OrderingCountToday", O.Default(0))
    /** Database column OrderingCountYesterday SqlType(INT), Default(0) */
    val orderingcountyesterday: Rep[Int] = column[Int]("OrderingCountYesterday", O.Default(0))
    /** Database column OrderingCountBefore SqlType(INT), Default(0) */
    val orderingcountbefore: Rep[Int] = column[Int]("OrderingCountBefore", O.Default(0))
    /** Database column CompleteCount SqlType(INT), Default(0) */
    val completecount: Rep[Int] = column[Int]("CompleteCount", O.Default(0))
    /** Database column CancelByUser SqlType(INT), Default(0) */
    val cancelbyuser: Rep[Int] = column[Int]("CancelByUser", O.Default(0))
    /** Database column CancelByAttache SqlType(INT), Default(0) */
    val cancelbyattache: Rep[Int] = column[Int]("CancelByAttache", O.Default(0))
    /** Database column CancelBySys SqlType(INT), Default(0) */
    val cancelbysys: Rep[Int] = column[Int]("CancelBySys", O.Default(0))
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TBkstat */
  lazy val TBkstat = new TableQuery(tag => new TBkstat(tag))

  /** Row type of table TBktrade */
  type TBktradeRow = HCons[Long,HCons[String,HCons[String,HCons[Long,HCons[Long,HCons[String,HCons[String,HCons[String,HCons[String,HCons[Int,HCons[java.sql.Timestamp,HCons[java.sql.Timestamp,HCons[Int,HCons[scala.math.BigDecimal,HCons[scala.math.BigDecimal,HCons[Long,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[Long,HCons[Int,HCons[String,HCons[String,HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for TBktradeRow providing default values if available in the database schema. */
  def TBktradeRow(tradeid: Long, citycode: String = "", areacode: String = "", userid: Long = 0L, bankid: Long = 0L, truename: String = "", address: String = "", mobile: String = "", remark: String = "", isurgent: Int = 0, lastmodifytime: java.sql.Timestamp, createtime: java.sql.Timestamp, state: Int = 0, lat: scala.math.BigDecimal = 0.000000000d, lon: scala.math.BigDecimal = 0.000000000d, attacheuserid: Long = 0L, cancelremark: String = "", cardgrade: String = "", occupation: String = "", fund: String = "", yearlyincome: String = "", userlabel: Long = 0L, cardcount: Int = 0, cardlist: String = "", channel: String = "", idcard: Option[String] = None, jobtype: Option[String] = None, company: Option[String] = None, socialensure: Option[String] = None, jobprove: Option[String] = None, graduation: Option[String] = None): TBktradeRow = {
    tradeid :: citycode :: areacode :: userid :: bankid :: truename :: address :: mobile :: remark :: isurgent :: lastmodifytime :: createtime :: state :: lat :: lon :: attacheuserid :: cancelremark :: cardgrade :: occupation :: fund :: yearlyincome :: userlabel :: cardcount :: cardlist :: channel :: idcard :: jobtype :: company :: socialensure :: jobprove :: graduation :: HNil
  }
  /** GetResult implicit for fetching TBktradeRow objects using plain SQL queries */
  implicit def GetResultTBktradeRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[java.sql.Timestamp], e4: GR[scala.math.BigDecimal], e5: GR[Option[String]]): GR[TBktradeRow] = GR{
    prs => import prs._
    <<[Long] :: <<[String] :: <<[String] :: <<[Long] :: <<[Long] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[Int] :: <<[java.sql.Timestamp] :: <<[java.sql.Timestamp] :: <<[Int] :: <<[scala.math.BigDecimal] :: <<[scala.math.BigDecimal] :: <<[Long] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[Long] :: <<[Int] :: <<[String] :: <<[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: HNil
  }
  /** Table description of table T_BkTrade. Objects of this class serve as prototypes for rows in queries. */
  class TBktrade(_tableTag: Tag) extends Table[TBktradeRow](_tableTag, "T_BkTrade") {
    def * = tradeid :: citycode :: areacode :: userid :: bankid :: truename :: address :: mobile :: remark :: isurgent :: lastmodifytime :: createtime :: state :: lat :: lon :: attacheuserid :: cancelremark :: cardgrade :: occupation :: fund :: yearlyincome :: userlabel :: cardcount :: cardlist :: channel :: idcard :: jobtype :: company :: socialensure :: jobprove :: graduation :: HNil

    /** Database column TradeID SqlType(BIGINT), AutoInc, PrimaryKey */
    val tradeid: Rep[Long] = column[Long]("TradeID", O.AutoInc, O.PrimaryKey)
    /** Database column CityCode SqlType(VARCHAR), Length(50,true), Default() */
    val citycode: Rep[String] = column[String]("CityCode", O.Length(50,varying=true), O.Default(""))
    /** Database column AreaCode SqlType(VARCHAR), Length(50,true), Default() */
    val areacode: Rep[String] = column[String]("AreaCode", O.Length(50,varying=true), O.Default(""))
    /** Database column UserID SqlType(BIGINT), Default(0) */
    val userid: Rep[Long] = column[Long]("UserID", O.Default(0L))
    /** Database column BankID SqlType(BIGINT), Default(0) */
    val bankid: Rep[Long] = column[Long]("BankID", O.Default(0L))
    /** Database column TrueName SqlType(VARCHAR), Length(255,true), Default() */
    val truename: Rep[String] = column[String]("TrueName", O.Length(255,varying=true), O.Default(""))
    /** Database column Address SqlType(VARCHAR), Length(255,true), Default() */
    val address: Rep[String] = column[String]("Address", O.Length(255,varying=true), O.Default(""))
    /** Database column Mobile SqlType(VARCHAR), Length(255,true), Default() */
    val mobile: Rep[String] = column[String]("Mobile", O.Length(255,varying=true), O.Default(""))
    /** Database column Remark SqlType(VARCHAR), Length(500,true), Default() */
    val remark: Rep[String] = column[String]("Remark", O.Length(500,varying=true), O.Default(""))
    /** Database column IsUrgent SqlType(INT), Default(0) */
    val isurgent: Rep[Int] = column[Int]("IsUrgent", O.Default(0))
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column State SqlType(INT), Default(0) */
    val state: Rep[Int] = column[Int]("State", O.Default(0))
    /** Database column Lat SqlType(DECIMAL), Default(0.000000000) */
    val lat: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("Lat", O.Default(0.000000000d))
    /** Database column Lon SqlType(DECIMAL), Default(0.000000000) */
    val lon: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("Lon", O.Default(0.000000000d))
    /** Database column AttacheUserID SqlType(BIGINT), Default(0) */
    val attacheuserid: Rep[Long] = column[Long]("AttacheUserID", O.Default(0L))
    /** Database column CancelRemark SqlType(VARCHAR), Length(200,true), Default() */
    val cancelremark: Rep[String] = column[String]("CancelRemark", O.Length(200,varying=true), O.Default(""))
    /** Database column CardGrade SqlType(VARCHAR), Length(50,true), Default() */
    val cardgrade: Rep[String] = column[String]("CardGrade", O.Length(50,varying=true), O.Default(""))
    /** Database column Occupation SqlType(VARCHAR), Length(50,true), Default() */
    val occupation: Rep[String] = column[String]("Occupation", O.Length(50,varying=true), O.Default(""))
    /** Database column Fund SqlType(VARCHAR), Length(200,true), Default() */
    val fund: Rep[String] = column[String]("Fund", O.Length(200,varying=true), O.Default(""))
    /** Database column YearlyIncome SqlType(VARCHAR), Length(50,true), Default() */
    val yearlyincome: Rep[String] = column[String]("YearlyIncome", O.Length(50,varying=true), O.Default(""))
    /** Database column UserLabel SqlType(BIGINT), Default(0) */
    val userlabel: Rep[Long] = column[Long]("UserLabel", O.Default(0L))
    /** Database column CardCount SqlType(INT), Default(0) */
    val cardcount: Rep[Int] = column[Int]("CardCount", O.Default(0))
    /** Database column CardList SqlType(VARCHAR), Length(500,true), Default() */
    val cardlist: Rep[String] = column[String]("CardList", O.Length(500,varying=true), O.Default(""))
    /** Database column Channel SqlType(VARCHAR), Length(50,true), Default() */
    val channel: Rep[String] = column[String]("Channel", O.Length(50,varying=true), O.Default(""))
    /** Database column IdCard SqlType(VARCHAR), Length(255,true), Default(None) */
    val idcard: Rep[Option[String]] = column[Option[String]]("IdCard", O.Length(255,varying=true), O.Default(None))
    /** Database column JobType SqlType(VARCHAR), Length(45,true), Default(None) */
    val jobtype: Rep[Option[String]] = column[Option[String]]("JobType", O.Length(45,varying=true), O.Default(None))
    /** Database column Company SqlType(VARCHAR), Length(45,true), Default(None) */
    val company: Rep[Option[String]] = column[Option[String]]("Company", O.Length(45,varying=true), O.Default(None))
    /** Database column SocialEnsure SqlType(VARCHAR), Length(45,true), Default(None) */
    val socialensure: Rep[Option[String]] = column[Option[String]]("SocialEnsure", O.Length(45,varying=true), O.Default(None))
    /** Database column JobProve SqlType(VARCHAR), Length(45,true), Default(None) */
    val jobprove: Rep[Option[String]] = column[Option[String]]("JobProve", O.Length(45,varying=true), O.Default(None))
    /** Database column Graduation SqlType(VARCHAR), Length(45,true), Default(None) */
    val graduation: Rep[Option[String]] = column[Option[String]]("Graduation", O.Length(45,varying=true), O.Default(None))

    /** Index over (bankid,citycode,lastmodifytime) (database name BankID_CityCode_LastModifyTime) */
    val index1 = index("BankID_CityCode_LastModifyTime", bankid :: citycode :: lastmodifytime :: HNil)
    /** Index over (state,tradeid) (database name idx_State_TradeID) */
    val index2 = index("idx_State_TradeID", state :: tradeid :: HNil)
    /** Index over (userid) (database name idx_UserID) */
    val index3 = index("idx_UserID", userid :: HNil)
  }
  /** Collection-like TableQuery object for table TBktrade */
  lazy val TBktrade = new TableQuery(tag => new TBktrade(tag))

  /** Entity class storing rows of table TCardapplyresult
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param adid Database column AdId SqlType(VARCHAR), Length(64,true), Default()
   *  @param orderid Database column OrderId SqlType(VARCHAR), Length(64,true), Default()
   *  @param resulttime Database column ResultTime SqlType(VARCHAR), Length(64,true), Default(1990-01-01 00:00:00)
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TCardapplyresultRow(autoid: Long, adid: String = "", orderid: String = "", resulttime: String = "1990-01-01 00:00:00", createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TCardapplyresultRow objects using plain SQL queries */
  implicit def GetResultTCardapplyresultRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[TCardapplyresultRow] = GR{
    prs => import prs._
    TCardapplyresultRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_CardApplyResult. Objects of this class serve as prototypes for rows in queries. */
  class TCardapplyresult(_tableTag: Tag) extends Table[TCardapplyresultRow](_tableTag, "T_CardApplyResult") {
    def * = (autoid, adid, orderid, resulttime, createtime) <> (TCardapplyresultRow.tupled, TCardapplyresultRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(adid), Rep.Some(orderid), Rep.Some(resulttime), Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TCardapplyresultRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column AdId SqlType(VARCHAR), Length(64,true), Default() */
    val adid: Rep[String] = column[String]("AdId", O.Length(64,varying=true), O.Default(""))
    /** Database column OrderId SqlType(VARCHAR), Length(64,true), Default() */
    val orderid: Rep[String] = column[String]("OrderId", O.Length(64,varying=true), O.Default(""))
    /** Database column ResultTime SqlType(VARCHAR), Length(64,true), Default(1990-01-01 00:00:00) */
    val resulttime: Rep[String] = column[String]("ResultTime", O.Length(64,varying=true), O.Default("1990-01-01 00:00:00"))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TCardapplyresult */
  lazy val TCardapplyresult = new TableQuery(tag => new TCardapplyresult(tag))

  /** Entity class storing rows of table TCityFull
   *  @param cityid Database column CityID SqlType(INT), PrimaryKey, Default(0)
   *  @param code Database column Code SqlType(VARCHAR), Length(6,true)
   *  @param provincecode Database column ProvinceCode SqlType(VARCHAR), Length(6,true), Default()
   *  @param name Database column Name SqlType(VARCHAR), Length(50,true), Default()
   *  @param phonecode Database column PhoneCode SqlType(VARCHAR), Length(10,true), Default()
   *  @param deletestatus Database column DeleteStatus SqlType(BIT) */
  case class TCityFullRow(cityid: Int = 0, code: String, provincecode: String = "", name: String = "", phonecode: String = "", deletestatus: Boolean)
  /** GetResult implicit for fetching TCityFullRow objects using plain SQL queries */
  implicit def GetResultTCityFullRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean]): GR[TCityFullRow] = GR{
    prs => import prs._
    TCityFullRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[String], <<[Boolean]))
  }
  /** Table description of table T_City_Full. Objects of this class serve as prototypes for rows in queries. */
  class TCityFull(_tableTag: Tag) extends Table[TCityFullRow](_tableTag, "T_City_Full") {
    def * = (cityid, code, provincecode, name, phonecode, deletestatus) <> (TCityFullRow.tupled, TCityFullRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(cityid), Rep.Some(code), Rep.Some(provincecode), Rep.Some(name), Rep.Some(phonecode), Rep.Some(deletestatus)).shaped.<>({r=>import r._; _1.map(_=> TCityFullRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CityID SqlType(INT), PrimaryKey, Default(0) */
    val cityid: Rep[Int] = column[Int]("CityID", O.PrimaryKey, O.Default(0))
    /** Database column Code SqlType(VARCHAR), Length(6,true) */
    val code: Rep[String] = column[String]("Code", O.Length(6,varying=true))
    /** Database column ProvinceCode SqlType(VARCHAR), Length(6,true), Default() */
    val provincecode: Rep[String] = column[String]("ProvinceCode", O.Length(6,varying=true), O.Default(""))
    /** Database column Name SqlType(VARCHAR), Length(50,true), Default() */
    val name: Rep[String] = column[String]("Name", O.Length(50,varying=true), O.Default(""))
    /** Database column PhoneCode SqlType(VARCHAR), Length(10,true), Default() */
    val phonecode: Rep[String] = column[String]("PhoneCode", O.Length(10,varying=true), O.Default(""))
    /** Database column DeleteStatus SqlType(BIT) */
    val deletestatus: Rep[Boolean] = column[Boolean]("DeleteStatus")
  }
  /** Collection-like TableQuery object for table TCityFull */
  lazy val TCityFull = new TableQuery(tag => new TCityFull(tag))

  /** Row type of table TCreditcard */
  type TCreditcardRow = HCons[Long,HCons[Option[String],HCons[Int,HCons[Int,HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Long,HCons[Option[String],HCons[String,HCons[Option[String],HCons[String,HCons[String,HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[java.sql.Timestamp,HCons[java.sql.Timestamp,HCons[Option[Long],HCons[Option[Int],HCons[Option[String],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for TCreditcardRow providing default values if available in the database schema. */
  def TCreditcardRow(cardid: Long, tags: Option[String] = None, sugest: Int = 0, canapply: Int = 0, applyurl: Option[String] = None, pointway: Option[String] = None, annualfee: Option[String] = None, freeannualfee: Option[String] = None, smscharge: Option[String] = None, remark: Option[String] = None, bank: Long, city: Option[String] = None, cardname: String, cardlevel: Option[String] = None, cardorg: String, cardcurrency: String, pointvalid: Option[String] = None, cashlimit: Option[String] = None, minrepayment: Option[String] = None, netpaymentlimit: Option[String] = None, advancecash: Option[String] = None, stagestype: Option[String] = None, stagesstart: Option[String] = None, stagesrate: Option[String] = None, stagespayment: Option[String] = None, stagesrepaymentpolice: Option[String] = None, stagesapply: Option[String] = None, freeaccrualdays: Option[String] = None, dayaccrual: Option[String] = None, imageurl: Option[String] = None, cardurl: Option[String] = None, createtime: java.sql.Timestamp, lasttime: java.sql.Timestamp, status: Option[Long] = None, disable: Option[Int] = None, remoteimageurl: Option[String] = None): TCreditcardRow = {
    cardid :: tags :: sugest :: canapply :: applyurl :: pointway :: annualfee :: freeannualfee :: smscharge :: remark :: bank :: city :: cardname :: cardlevel :: cardorg :: cardcurrency :: pointvalid :: cashlimit :: minrepayment :: netpaymentlimit :: advancecash :: stagestype :: stagesstart :: stagesrate :: stagespayment :: stagesrepaymentpolice :: stagesapply :: freeaccrualdays :: dayaccrual :: imageurl :: cardurl :: createtime :: lasttime :: status :: disable :: remoteimageurl :: HNil
  }
  /** GetResult implicit for fetching TCreditcardRow objects using plain SQL queries */
  implicit def GetResultTCreditcardRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[Int], e3: GR[String], e4: GR[java.sql.Timestamp], e5: GR[Option[Long]], e6: GR[Option[Int]]): GR[TCreditcardRow] = GR{
    prs => import prs._
    <<[Long] :: <<?[String] :: <<[Int] :: <<[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<[Long] :: <<?[String] :: <<[String] :: <<?[String] :: <<[String] :: <<[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<[java.sql.Timestamp] :: <<[java.sql.Timestamp] :: <<?[Long] :: <<?[Int] :: <<?[String] :: HNil
  }
  /** Table description of table T_CreditCard. Objects of this class serve as prototypes for rows in queries. */
  class TCreditcard(_tableTag: Tag) extends Table[TCreditcardRow](_tableTag, "T_CreditCard") {
    def * = cardid :: tags :: sugest :: canapply :: applyurl :: pointway :: annualfee :: freeannualfee :: smscharge :: remark :: bank :: city :: cardname :: cardlevel :: cardorg :: cardcurrency :: pointvalid :: cashlimit :: minrepayment :: netpaymentlimit :: advancecash :: stagestype :: stagesstart :: stagesrate :: stagespayment :: stagesrepaymentpolice :: stagesapply :: freeaccrualdays :: dayaccrual :: imageurl :: cardurl :: createtime :: lasttime :: status :: disable :: remoteimageurl :: HNil

    /** Database column cardId SqlType(BIGINT), AutoInc, PrimaryKey */
    val cardid: Rep[Long] = column[Long]("cardId", O.AutoInc, O.PrimaryKey)
    /** Database column tags SqlType(VARCHAR), Length(200,true), Default(None) */
    val tags: Rep[Option[String]] = column[Option[String]]("tags", O.Length(200,varying=true), O.Default(None))
    /** Database column sugest SqlType(INT), Default(0) */
    val sugest: Rep[Int] = column[Int]("sugest", O.Default(0))
    /** Database column canApply SqlType(INT), Default(0) */
    val canapply: Rep[Int] = column[Int]("canApply", O.Default(0))
    /** Database column applyURL SqlType(VARCHAR), Length(200,true), Default(None) */
    val applyurl: Rep[Option[String]] = column[Option[String]]("applyURL", O.Length(200,varying=true), O.Default(None))
    /** Database column pointWay SqlType(TEXT), Default(None) */
    val pointway: Rep[Option[String]] = column[Option[String]]("pointWay", O.Default(None))
    /** Database column annualFee SqlType(TEXT), Default(None) */
    val annualfee: Rep[Option[String]] = column[Option[String]]("annualFee", O.Default(None))
    /** Database column freeAnnualFee SqlType(VARCHAR), Length(1000,true), Default(None) */
    val freeannualfee: Rep[Option[String]] = column[Option[String]]("freeAnnualFee", O.Length(1000,varying=true), O.Default(None))
    /** Database column smsCharge SqlType(VARCHAR), Length(1000,true), Default(None) */
    val smscharge: Rep[Option[String]] = column[Option[String]]("smsCharge", O.Length(1000,varying=true), O.Default(None))
    /** Database column remark SqlType(TEXT), Default(None) */
    val remark: Rep[Option[String]] = column[Option[String]]("remark", O.Default(None))
    /** Database column bank SqlType(BIGINT) */
    val bank: Rep[Long] = column[Long]("bank")
    /** Database column city SqlType(VARCHAR), Length(200,true), Default(None) */
    val city: Rep[Option[String]] = column[Option[String]]("city", O.Length(200,varying=true), O.Default(None))
    /** Database column cardName SqlType(VARCHAR), Length(50,true) */
    val cardname: Rep[String] = column[String]("cardName", O.Length(50,varying=true))
    /** Database column cardLevel SqlType(VARCHAR), Length(500,true), Default(None) */
    val cardlevel: Rep[Option[String]] = column[Option[String]]("cardLevel", O.Length(500,varying=true), O.Default(None))
    /** Database column cardOrg SqlType(VARCHAR), Length(50,true) */
    val cardorg: Rep[String] = column[String]("cardOrg", O.Length(50,varying=true))
    /** Database column cardCurrency SqlType(VARCHAR), Length(500,true) */
    val cardcurrency: Rep[String] = column[String]("cardCurrency", O.Length(500,varying=true))
    /** Database column pointValid SqlType(VARCHAR), Length(500,true), Default(None) */
    val pointvalid: Rep[Option[String]] = column[Option[String]]("pointValid", O.Length(500,varying=true), O.Default(None))
    /** Database column cashLimit SqlType(VARCHAR), Length(50,true), Default(None) */
    val cashlimit: Rep[Option[String]] = column[Option[String]]("cashLimit", O.Length(50,varying=true), O.Default(None))
    /** Database column minRepayment SqlType(VARCHAR), Length(1000,true), Default(None) */
    val minrepayment: Rep[Option[String]] = column[Option[String]]("minRepayment", O.Length(1000,varying=true), O.Default(None))
    /** Database column netPaymentLimit SqlType(VARCHAR), Length(1000,true), Default(None) */
    val netpaymentlimit: Rep[Option[String]] = column[Option[String]]("netPaymentLimit", O.Length(1000,varying=true), O.Default(None))
    /** Database column advanceCash SqlType(VARCHAR), Length(1000,true), Default(None) */
    val advancecash: Rep[Option[String]] = column[Option[String]]("advanceCash", O.Length(1000,varying=true), O.Default(None))
    /** Database column stagesType SqlType(VARCHAR), Length(1000,true), Default(None) */
    val stagestype: Rep[Option[String]] = column[Option[String]]("stagesType", O.Length(1000,varying=true), O.Default(None))
    /** Database column stagesStart SqlType(VARCHAR), Length(1000,true), Default(None) */
    val stagesstart: Rep[Option[String]] = column[Option[String]]("stagesStart", O.Length(1000,varying=true), O.Default(None))
    /** Database column stagesRate SqlType(VARCHAR), Length(5000,true), Default(None) */
    val stagesrate: Rep[Option[String]] = column[Option[String]]("stagesRate", O.Length(5000,varying=true), O.Default(None))
    /** Database column stagesPayment SqlType(VARCHAR), Length(1000,true), Default(None) */
    val stagespayment: Rep[Option[String]] = column[Option[String]]("stagesPayment", O.Length(1000,varying=true), O.Default(None))
    /** Database column stagesRepaymentPolice SqlType(VARCHAR), Length(1000,true), Default(None) */
    val stagesrepaymentpolice: Rep[Option[String]] = column[Option[String]]("stagesRepaymentPolice", O.Length(1000,varying=true), O.Default(None))
    /** Database column stagesApply SqlType(VARCHAR), Length(1000,true), Default(None) */
    val stagesapply: Rep[Option[String]] = column[Option[String]]("stagesApply", O.Length(1000,varying=true), O.Default(None))
    /** Database column freeAccrualDays SqlType(VARCHAR), Length(1000,true), Default(None) */
    val freeaccrualdays: Rep[Option[String]] = column[Option[String]]("freeAccrualDays", O.Length(1000,varying=true), O.Default(None))
    /** Database column dayAccrual SqlType(VARCHAR), Length(1000,true), Default(None) */
    val dayaccrual: Rep[Option[String]] = column[Option[String]]("dayAccrual", O.Length(1000,varying=true), O.Default(None))
    /** Database column imageURL SqlType(VARCHAR), Length(200,true), Default(None) */
    val imageurl: Rep[Option[String]] = column[Option[String]]("imageURL", O.Length(200,varying=true), O.Default(None))
    /** Database column cardUrl SqlType(VARCHAR), Length(200,true), Default(None) */
    val cardurl: Rep[Option[String]] = column[Option[String]]("cardUrl", O.Length(200,varying=true), O.Default(None))
    /** Database column createTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("createTime")
    /** Database column lastTime SqlType(DATETIME) */
    val lasttime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("lastTime")
    /** Database column status SqlType(BIGINT), Default(None) */
    val status: Rep[Option[Long]] = column[Option[Long]]("status", O.Default(None))
    /** Database column disable SqlType(INT), Default(None) */
    val disable: Rep[Option[Int]] = column[Option[Int]]("disable", O.Default(None))
    /** Database column remoteImageURL SqlType(VARCHAR), Length(200,true), Default(None) */
    val remoteimageurl: Rep[Option[String]] = column[Option[String]]("remoteImageURL", O.Length(200,varying=true), O.Default(None))

    /** Uniqueness Index over (bank,cardname) (database name idx_T_CreditCard_Name) */
    val index1 = index("idx_T_CreditCard_Name", bank :: cardname :: HNil, unique=true)
  }
  /** Collection-like TableQuery object for table TCreditcard */
  lazy val TCreditcard = new TableQuery(tag => new TCreditcard(tag))

  /** Entity class storing rows of table TCreditcardDicNormal
   *  @param dicid Database column DicId SqlType(VARCHAR), PrimaryKey, Length(10,true)
   *  @param name Database column Name SqlType(VARCHAR), Length(50,true)
   *  @param pid Database column PId SqlType(VARCHAR), Length(10,true), Default(None)
   *  @param createtime Database column CreateTime SqlType(DATETIME)
   *  @param status Database column Status SqlType(INT), Default(0)
   *  @param disable Database column Disable SqlType(INT), Default(None)
   *  @param sequence Database column sequence SqlType(INT), Default(Some(0)) */
  case class TCreditcardDicNormalRow(dicid: String, name: String, pid: Option[String] = None, createtime: java.sql.Timestamp, status: Int = 0, disable: Option[Int] = None, sequence: Option[Int] = Some(0))
  /** GetResult implicit for fetching TCreditcardDicNormalRow objects using plain SQL queries */
  implicit def GetResultTCreditcardDicNormalRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[java.sql.Timestamp], e3: GR[Int], e4: GR[Option[Int]]): GR[TCreditcardDicNormalRow] = GR{
    prs => import prs._
    TCreditcardDicNormalRow.tupled((<<[String], <<[String], <<?[String], <<[java.sql.Timestamp], <<[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table T_CreditCard_Dic_Normal. Objects of this class serve as prototypes for rows in queries. */
  class TCreditcardDicNormal(_tableTag: Tag) extends Table[TCreditcardDicNormalRow](_tableTag, "T_CreditCard_Dic_Normal") {
    def * = (dicid, name, pid, createtime, status, disable, sequence) <> (TCreditcardDicNormalRow.tupled, TCreditcardDicNormalRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(dicid), Rep.Some(name), pid, Rep.Some(createtime), Rep.Some(status), disable, sequence).shaped.<>({r=>import r._; _1.map(_=> TCreditcardDicNormalRow.tupled((_1.get, _2.get, _3, _4.get, _5.get, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column DicId SqlType(VARCHAR), PrimaryKey, Length(10,true) */
    val dicid: Rep[String] = column[String]("DicId", O.PrimaryKey, O.Length(10,varying=true))
    /** Database column Name SqlType(VARCHAR), Length(50,true) */
    val name: Rep[String] = column[String]("Name", O.Length(50,varying=true))
    /** Database column PId SqlType(VARCHAR), Length(10,true), Default(None) */
    val pid: Rep[Option[String]] = column[Option[String]]("PId", O.Length(10,varying=true), O.Default(None))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column Status SqlType(INT), Default(0) */
    val status: Rep[Int] = column[Int]("Status", O.Default(0))
    /** Database column Disable SqlType(INT), Default(None) */
    val disable: Rep[Option[Int]] = column[Option[Int]]("Disable", O.Default(None))
    /** Database column sequence SqlType(INT), Default(Some(0)) */
    val sequence: Rep[Option[Int]] = column[Option[Int]]("sequence", O.Default(Some(0)))

    /** Index over (pid) (database name idx_T_CreditCard_Dic_Normal_PID) */
    val index1 = index("idx_T_CreditCard_Dic_Normal_PID", pid)
    /** Index over (status) (database name idx_T_CreditCard_Dic_Normal_Status) */
    val index2 = index("idx_T_CreditCard_Dic_Normal_Status", status)
  }
  /** Collection-like TableQuery object for table TCreditcardDicNormal */
  lazy val TCreditcardDicNormal = new TableQuery(tag => new TCreditcardDicNormal(tag))

  /** Entity class storing rows of table TCreditcarddicTag
   *  @param tagid Database column tagId SqlType(VARCHAR), PrimaryKey, Length(9,true)
   *  @param parenttagid Database column parentTagId SqlType(VARCHAR), Length(6,true), Default(None)
   *  @param title Database column title SqlType(VARCHAR), Length(50,true)
   *  @param sequence Database column sequence SqlType(INT), Default(0) */
  case class TCreditcarddicTagRow(tagid: String, parenttagid: Option[String] = None, title: String, sequence: Int = 0)
  /** GetResult implicit for fetching TCreditcarddicTagRow objects using plain SQL queries */
  implicit def GetResultTCreditcarddicTagRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Int]): GR[TCreditcarddicTagRow] = GR{
    prs => import prs._
    TCreditcarddicTagRow.tupled((<<[String], <<?[String], <<[String], <<[Int]))
  }
  /** Table description of table T_CreditCardDic_Tag. Objects of this class serve as prototypes for rows in queries. */
  class TCreditcarddicTag(_tableTag: Tag) extends Table[TCreditcarddicTagRow](_tableTag, "T_CreditCardDic_Tag") {
    def * = (tagid, parenttagid, title, sequence) <> (TCreditcarddicTagRow.tupled, TCreditcarddicTagRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(tagid), parenttagid, Rep.Some(title), Rep.Some(sequence)).shaped.<>({r=>import r._; _1.map(_=> TCreditcarddicTagRow.tupled((_1.get, _2, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column tagId SqlType(VARCHAR), PrimaryKey, Length(9,true) */
    val tagid: Rep[String] = column[String]("tagId", O.PrimaryKey, O.Length(9,varying=true))
    /** Database column parentTagId SqlType(VARCHAR), Length(6,true), Default(None) */
    val parenttagid: Rep[Option[String]] = column[Option[String]]("parentTagId", O.Length(6,varying=true), O.Default(None))
    /** Database column title SqlType(VARCHAR), Length(50,true) */
    val title: Rep[String] = column[String]("title", O.Length(50,varying=true))
    /** Database column sequence SqlType(INT), Default(0) */
    val sequence: Rep[Int] = column[Int]("sequence", O.Default(0))
  }
  /** Collection-like TableQuery object for table TCreditcarddicTag */
  lazy val TCreditcarddicTag = new TableQuery(tag => new TCreditcarddicTag(tag))

  /** Entity class storing rows of table TCreditcardItem
   *  @param carditemid Database column cardItemId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param cardid Database column cardId SqlType(BIGINT)
   *  @param imageurl Database column imageURL SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param cardurl Database column cardUrl SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param carditemname Database column cardItemName SqlType(VARCHAR), Length(100,true)
   *  @param cardlevel Database column cardLevel SqlType(VARCHAR), Length(50,true)
   *  @param cardorg Database column cardOrg SqlType(VARCHAR), Length(50,true)
   *  @param cardcurrency Database column cardCurrency SqlType(VARCHAR), Length(200,true)
   *  @param createtime Database column createTime SqlType(DATETIME)
   *  @param lasttime Database column lastTime SqlType(DATETIME)
   *  @param remoteimageurl Database column remoteImageURL SqlType(VARCHAR), Length(200,true), Default(None) */
  case class TCreditcardItemRow(carditemid: Long, cardid: Long, imageurl: Option[String] = None, cardurl: Option[String] = None, carditemname: String, cardlevel: String, cardorg: String, cardcurrency: String, createtime: java.sql.Timestamp, lasttime: java.sql.Timestamp, remoteimageurl: Option[String] = None)
  /** GetResult implicit for fetching TCreditcardItemRow objects using plain SQL queries */
  implicit def GetResultTCreditcardItemRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[String], e3: GR[java.sql.Timestamp]): GR[TCreditcardItemRow] = GR{
    prs => import prs._
    TCreditcardItemRow.tupled((<<[Long], <<[Long], <<?[String], <<?[String], <<[String], <<[String], <<[String], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<?[String]))
  }
  /** Table description of table T_CreditCard_Item. Objects of this class serve as prototypes for rows in queries. */
  class TCreditcardItem(_tableTag: Tag) extends Table[TCreditcardItemRow](_tableTag, "T_CreditCard_Item") {
    def * = (carditemid, cardid, imageurl, cardurl, carditemname, cardlevel, cardorg, cardcurrency, createtime, lasttime, remoteimageurl) <> (TCreditcardItemRow.tupled, TCreditcardItemRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(carditemid), Rep.Some(cardid), imageurl, cardurl, Rep.Some(carditemname), Rep.Some(cardlevel), Rep.Some(cardorg), Rep.Some(cardcurrency), Rep.Some(createtime), Rep.Some(lasttime), remoteimageurl).shaped.<>({r=>import r._; _1.map(_=> TCreditcardItemRow.tupled((_1.get, _2.get, _3, _4, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column cardItemId SqlType(BIGINT), AutoInc, PrimaryKey */
    val carditemid: Rep[Long] = column[Long]("cardItemId", O.AutoInc, O.PrimaryKey)
    /** Database column cardId SqlType(BIGINT) */
    val cardid: Rep[Long] = column[Long]("cardId")
    /** Database column imageURL SqlType(VARCHAR), Length(200,true), Default(None) */
    val imageurl: Rep[Option[String]] = column[Option[String]]("imageURL", O.Length(200,varying=true), O.Default(None))
    /** Database column cardUrl SqlType(VARCHAR), Length(200,true), Default(None) */
    val cardurl: Rep[Option[String]] = column[Option[String]]("cardUrl", O.Length(200,varying=true), O.Default(None))
    /** Database column cardItemName SqlType(VARCHAR), Length(100,true) */
    val carditemname: Rep[String] = column[String]("cardItemName", O.Length(100,varying=true))
    /** Database column cardLevel SqlType(VARCHAR), Length(50,true) */
    val cardlevel: Rep[String] = column[String]("cardLevel", O.Length(50,varying=true))
    /** Database column cardOrg SqlType(VARCHAR), Length(50,true) */
    val cardorg: Rep[String] = column[String]("cardOrg", O.Length(50,varying=true))
    /** Database column cardCurrency SqlType(VARCHAR), Length(200,true) */
    val cardcurrency: Rep[String] = column[String]("cardCurrency", O.Length(200,varying=true))
    /** Database column createTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("createTime")
    /** Database column lastTime SqlType(DATETIME) */
    val lasttime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("lastTime")
    /** Database column remoteImageURL SqlType(VARCHAR), Length(200,true), Default(None) */
    val remoteimageurl: Rep[Option[String]] = column[Option[String]]("remoteImageURL", O.Length(200,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table TCreditcardItem */
  lazy val TCreditcardItem = new TableQuery(tag => new TCreditcardItem(tag))

  /** Entity class storing rows of table TCreditcardRule
   *  @param id Database column id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param bankid Database column bankId SqlType(INT), Default(None)
   *  @param level Database column level SqlType(VARCHAR), Length(64,true), Default(None)
   *  @param rule Database column rule SqlType(VARCHAR), Length(128,true), Default(None) */
  case class TCreditcardRuleRow(id: Option[String] = None, bankid: Option[Int] = None, level: Option[String] = None, rule: Option[String] = None)
  /** GetResult implicit for fetching TCreditcardRuleRow objects using plain SQL queries */
  implicit def GetResultTCreditcardRuleRow(implicit e0: GR[Option[String]], e1: GR[Option[Int]]): GR[TCreditcardRuleRow] = GR{
    prs => import prs._
    TCreditcardRuleRow.tupled((<<?[String], <<?[Int], <<?[String], <<?[String]))
  }
  /** Table description of table T_CreditCard_Rule. Objects of this class serve as prototypes for rows in queries. */
  class TCreditcardRule(_tableTag: Tag) extends Table[TCreditcardRuleRow](_tableTag, "T_CreditCard_Rule") {
    def * = (id, bankid, level, rule) <> (TCreditcardRuleRow.tupled, TCreditcardRuleRow.unapply)

    /** Database column id SqlType(VARCHAR), Length(32,true), Default(None) */
    val id: Rep[Option[String]] = column[Option[String]]("id", O.Length(32,varying=true), O.Default(None))
    /** Database column bankId SqlType(INT), Default(None) */
    val bankid: Rep[Option[Int]] = column[Option[Int]]("bankId", O.Default(None))
    /** Database column level SqlType(VARCHAR), Length(64,true), Default(None) */
    val level: Rep[Option[String]] = column[Option[String]]("level", O.Length(64,varying=true), O.Default(None))
    /** Database column rule SqlType(VARCHAR), Length(128,true), Default(None) */
    val rule: Rep[Option[String]] = column[Option[String]]("rule", O.Length(128,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table TCreditcardRule */
  lazy val TCreditcardRule = new TableQuery(tag => new TCreditcardRule(tag))

  /** Entity class storing rows of table TDicRegion
   *  @param code Database column Code SqlType(VARCHAR), PrimaryKey, Length(10,true)
   *  @param name Database column Name SqlType(VARCHAR), Length(50,true)
   *  @param status Database column Status SqlType(INT), Default(0)
   *  @param regiontype Database column RegionType SqlType(INT)
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TDicRegionRow(code: String, name: String, status: Int = 0, regiontype: Int, createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TDicRegionRow objects using plain SQL queries */
  implicit def GetResultTDicRegionRow(implicit e0: GR[String], e1: GR[Int], e2: GR[java.sql.Timestamp]): GR[TDicRegionRow] = GR{
    prs => import prs._
    TDicRegionRow.tupled((<<[String], <<[String], <<[Int], <<[Int], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_Dic_Region. Objects of this class serve as prototypes for rows in queries. */
  class TDicRegion(_tableTag: Tag) extends Table[TDicRegionRow](_tableTag, "T_Dic_Region") {
    def * = (code, name, status, regiontype, createtime) <> (TDicRegionRow.tupled, TDicRegionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(code), Rep.Some(name), Rep.Some(status), Rep.Some(regiontype), Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TDicRegionRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column Code SqlType(VARCHAR), PrimaryKey, Length(10,true) */
    val code: Rep[String] = column[String]("Code", O.PrimaryKey, O.Length(10,varying=true))
    /** Database column Name SqlType(VARCHAR), Length(50,true) */
    val name: Rep[String] = column[String]("Name", O.Length(50,varying=true))
    /** Database column Status SqlType(INT), Default(0) */
    val status: Rep[Int] = column[Int]("Status", O.Default(0))
    /** Database column RegionType SqlType(INT) */
    val regiontype: Rep[Int] = column[Int]("RegionType")
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TDicRegion */
  lazy val TDicRegion = new TableQuery(tag => new TDicRegion(tag))

  /** Entity class storing rows of table TEdbz
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column UserId SqlType(BIGINT)
   *  @param username Database column UserName SqlType(VARCHAR), Length(250,true)
   *  @param mobile Database column Mobile SqlType(VARCHAR), Length(250,true)
   *  @param bankid Database column BankId SqlType(INT)
   *  @param applytime Database column ApplyTime SqlType(DATETIME)
   *  @param aprovetime Database column AproveTime SqlType(DATETIME), Default(None)
   *  @param haszd Database column HasZd SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param howzd Database column HowZD SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param zdtype Database column ZdType SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param refundsendtime Database column RefundSendTime SqlType(DATETIME), Default(None)
   *  @param bankcode Database column BankCode SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param dtorder Database column DtOrder SqlType(DATETIME), Default(None)
   *  @param oidpaybill Database column OidPayBill SqlType(VARCHAR), Length(100,true), Default(None) */
  case class TEdbzRow(autoid: Long, userid: Long, username: String, mobile: String, bankid: Int, applytime: java.sql.Timestamp, aprovetime: Option[java.sql.Timestamp] = None, haszd: Option[String] = None, howzd: Option[String] = None, zdtype: Option[String] = None, refundsendtime: Option[java.sql.Timestamp] = None, bankcode: Option[String] = None, dtorder: Option[java.sql.Timestamp] = None, oidpaybill: Option[String] = None)
  /** GetResult implicit for fetching TEdbzRow objects using plain SQL queries */
  implicit def GetResultTEdbzRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[java.sql.Timestamp], e4: GR[Option[java.sql.Timestamp]], e5: GR[Option[String]]): GR[TEdbzRow] = GR{
    prs => import prs._
    TEdbzRow.tupled((<<[Long], <<[Long], <<[String], <<[String], <<[Int], <<[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[String], <<?[String], <<?[String], <<?[java.sql.Timestamp], <<?[String], <<?[java.sql.Timestamp], <<?[String]))
  }
  /** Table description of table T_Edbz. Objects of this class serve as prototypes for rows in queries. */
  class TEdbz(_tableTag: Tag) extends Table[TEdbzRow](_tableTag, "T_Edbz") {
    def * = (autoid, userid, username, mobile, bankid, applytime, aprovetime, haszd, howzd, zdtype, refundsendtime, bankcode, dtorder, oidpaybill) <> (TEdbzRow.tupled, TEdbzRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(userid), Rep.Some(username), Rep.Some(mobile), Rep.Some(bankid), Rep.Some(applytime), aprovetime, haszd, howzd, zdtype, refundsendtime, bankcode, dtorder, oidpaybill).shaped.<>({r=>import r._; _1.map(_=> TEdbzRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7, _8, _9, _10, _11, _12, _13, _14)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column UserId SqlType(BIGINT) */
    val userid: Rep[Long] = column[Long]("UserId")
    /** Database column UserName SqlType(VARCHAR), Length(250,true) */
    val username: Rep[String] = column[String]("UserName", O.Length(250,varying=true))
    /** Database column Mobile SqlType(VARCHAR), Length(250,true) */
    val mobile: Rep[String] = column[String]("Mobile", O.Length(250,varying=true))
    /** Database column BankId SqlType(INT) */
    val bankid: Rep[Int] = column[Int]("BankId")
    /** Database column ApplyTime SqlType(DATETIME) */
    val applytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("ApplyTime")
    /** Database column AproveTime SqlType(DATETIME), Default(None) */
    val aprovetime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("AproveTime", O.Default(None))
    /** Database column HasZd SqlType(VARCHAR), Length(45,true), Default(None) */
    val haszd: Rep[Option[String]] = column[Option[String]]("HasZd", O.Length(45,varying=true), O.Default(None))
    /** Database column HowZD SqlType(VARCHAR), Length(45,true), Default(None) */
    val howzd: Rep[Option[String]] = column[Option[String]]("HowZD", O.Length(45,varying=true), O.Default(None))
    /** Database column ZdType SqlType(VARCHAR), Length(45,true), Default(None) */
    val zdtype: Rep[Option[String]] = column[Option[String]]("ZdType", O.Length(45,varying=true), O.Default(None))
    /** Database column RefundSendTime SqlType(DATETIME), Default(None) */
    val refundsendtime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("RefundSendTime", O.Default(None))
    /** Database column BankCode SqlType(VARCHAR), Length(45,true), Default(None) */
    val bankcode: Rep[Option[String]] = column[Option[String]]("BankCode", O.Length(45,varying=true), O.Default(None))
    /** Database column DtOrder SqlType(DATETIME), Default(None) */
    val dtorder: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("DtOrder", O.Default(None))
    /** Database column OidPayBill SqlType(VARCHAR), Length(100,true), Default(None) */
    val oidpaybill: Rep[Option[String]] = column[Option[String]]("OidPayBill", O.Length(100,varying=true), O.Default(None))

    /** Uniqueness Index over (userid) (database name UserId_UNIQUE) */
    val index1 = index("UserId_UNIQUE", userid, unique=true)
  }
  /** Collection-like TableQuery object for table TEdbz */
  lazy val TEdbz = new TableQuery(tag => new TEdbz(tag))

  /** Entity class storing rows of table TGfactivity
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column UserId SqlType(BIGINT)
   *  @param username Database column UserName SqlType(VARCHAR), Length(255,true)
   *  @param mobile Database column Mobile SqlType(VARCHAR), Length(255,true)
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TGfactivityRow(autoid: Long, userid: Long, username: String, mobile: String, createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TGfactivityRow objects using plain SQL queries */
  implicit def GetResultTGfactivityRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[TGfactivityRow] = GR{
    prs => import prs._
    TGfactivityRow.tupled((<<[Long], <<[Long], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_GFActivity. Objects of this class serve as prototypes for rows in queries. */
  class TGfactivity(_tableTag: Tag) extends Table[TGfactivityRow](_tableTag, "T_GFActivity") {
    def * = (autoid, userid, username, mobile, createtime) <> (TGfactivityRow.tupled, TGfactivityRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(userid), Rep.Some(username), Rep.Some(mobile), Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TGfactivityRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column UserId SqlType(BIGINT) */
    val userid: Rep[Long] = column[Long]("UserId")
    /** Database column UserName SqlType(VARCHAR), Length(255,true) */
    val username: Rep[String] = column[String]("UserName", O.Length(255,varying=true))
    /** Database column Mobile SqlType(VARCHAR), Length(255,true) */
    val mobile: Rep[String] = column[String]("Mobile", O.Length(255,varying=true))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TGfactivity */
  lazy val TGfactivity = new TableQuery(tag => new TGfactivity(tag))

  /** Entity class storing rows of table TLink
   *  @param id Database column ID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param serviceid Database column ServiceId SqlType(INT)
   *  @param service Database column Service SqlType(VARCHAR), Length(200,true)
   *  @param title Database column Title SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param content Database column Content SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param sort Database column Sort SqlType(INT), Default(None)
   *  @param icon Database column Icon SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param bankid Database column BankId SqlType(INT), Default(None)
   *  @param bank Database column Bank SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param linkadd Database column LinkAdd SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param citycodes Database column CityCodes SqlType(VARCHAR), Length(300,true), Default(None)
   *  @param citys Database column Citys SqlType(VARCHAR), Length(300,true), Default(None)
   *  @param status Database column Status SqlType(INT), Default(Some(0)) */
  case class TLinkRow(id: Long, serviceid: Int, service: String, title: Option[String] = None, content: Option[String] = None, sort: Option[Int] = None, icon: Option[String] = None, bankid: Option[Int] = None, bank: Option[String] = None, linkadd: Option[String] = None, citycodes: Option[String] = None, citys: Option[String] = None, status: Option[Int] = Some(0))
  /** GetResult implicit for fetching TLinkRow objects using plain SQL queries */
  implicit def GetResultTLinkRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[String], e3: GR[Option[String]], e4: GR[Option[Int]]): GR[TLinkRow] = GR{
    prs => import prs._
    TLinkRow.tupled((<<[Long], <<[Int], <<[String], <<?[String], <<?[String], <<?[Int], <<?[String], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table T_Link. Objects of this class serve as prototypes for rows in queries. */
  class TLink(_tableTag: Tag) extends Table[TLinkRow](_tableTag, "T_Link") {
    def * = (id, serviceid, service, title, content, sort, icon, bankid, bank, linkadd, citycodes, citys, status) <> (TLinkRow.tupled, TLinkRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(serviceid), Rep.Some(service), title, content, sort, icon, bankid, bank, linkadd, citycodes, citys, status).shaped.<>({r=>import r._; _1.map(_=> TLinkRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column ServiceId SqlType(INT) */
    val serviceid: Rep[Int] = column[Int]("ServiceId")
    /** Database column Service SqlType(VARCHAR), Length(200,true) */
    val service: Rep[String] = column[String]("Service", O.Length(200,varying=true))
    /** Database column Title SqlType(VARCHAR), Length(200,true), Default(None) */
    val title: Rep[Option[String]] = column[Option[String]]("Title", O.Length(200,varying=true), O.Default(None))
    /** Database column Content SqlType(VARCHAR), Length(200,true), Default(None) */
    val content: Rep[Option[String]] = column[Option[String]]("Content", O.Length(200,varying=true), O.Default(None))
    /** Database column Sort SqlType(INT), Default(None) */
    val sort: Rep[Option[Int]] = column[Option[Int]]("Sort", O.Default(None))
    /** Database column Icon SqlType(VARCHAR), Length(200,true), Default(None) */
    val icon: Rep[Option[String]] = column[Option[String]]("Icon", O.Length(200,varying=true), O.Default(None))
    /** Database column BankId SqlType(INT), Default(None) */
    val bankid: Rep[Option[Int]] = column[Option[Int]]("BankId", O.Default(None))
    /** Database column Bank SqlType(VARCHAR), Length(200,true), Default(None) */
    val bank: Rep[Option[String]] = column[Option[String]]("Bank", O.Length(200,varying=true), O.Default(None))
    /** Database column LinkAdd SqlType(VARCHAR), Length(200,true), Default(None) */
    val linkadd: Rep[Option[String]] = column[Option[String]]("LinkAdd", O.Length(200,varying=true), O.Default(None))
    /** Database column CityCodes SqlType(VARCHAR), Length(300,true), Default(None) */
    val citycodes: Rep[Option[String]] = column[Option[String]]("CityCodes", O.Length(300,varying=true), O.Default(None))
    /** Database column Citys SqlType(VARCHAR), Length(300,true), Default(None) */
    val citys: Rep[Option[String]] = column[Option[String]]("Citys", O.Length(300,varying=true), O.Default(None))
    /** Database column Status SqlType(INT), Default(Some(0)) */
    val status: Rep[Option[Int]] = column[Option[Int]]("Status", O.Default(Some(0)))
  }
  /** Collection-like TableQuery object for table TLink */
  lazy val TLink = new TableQuery(tag => new TLink(tag))

  /** Entity class storing rows of table TLinkchannel
   *  @param id Database column ID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param channelcode Database column ChannelCode SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param channelname Database column ChannelName SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param remark Database column Remark SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param status Database column Status SqlType(INT), Default(Some(0))
   *  @param createtime Database column CreateTime SqlType(VARCHAR), Length(200,true), Default(None) */
  case class TLinkchannelRow(id: Long, channelcode: Option[String] = None, channelname: Option[String] = None, remark: Option[String] = None, status: Option[Int] = Some(0), createtime: Option[String] = None)
  /** GetResult implicit for fetching TLinkchannelRow objects using plain SQL queries */
  implicit def GetResultTLinkchannelRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[TLinkchannelRow] = GR{
    prs => import prs._
    TLinkchannelRow.tupled((<<[Long], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[String]))
  }
  /** Table description of table T_LinkChannel. Objects of this class serve as prototypes for rows in queries. */
  class TLinkchannel(_tableTag: Tag) extends Table[TLinkchannelRow](_tableTag, "T_LinkChannel") {
    def * = (id, channelcode, channelname, remark, status, createtime) <> (TLinkchannelRow.tupled, TLinkchannelRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), channelcode, channelname, remark, status, createtime).shaped.<>({r=>import r._; _1.map(_=> TLinkchannelRow.tupled((_1.get, _2, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column ChannelCode SqlType(VARCHAR), Length(200,true), Default(None) */
    val channelcode: Rep[Option[String]] = column[Option[String]]("ChannelCode", O.Length(200,varying=true), O.Default(None))
    /** Database column ChannelName SqlType(VARCHAR), Length(200,true), Default(None) */
    val channelname: Rep[Option[String]] = column[Option[String]]("ChannelName", O.Length(200,varying=true), O.Default(None))
    /** Database column Remark SqlType(VARCHAR), Length(200,true), Default(None) */
    val remark: Rep[Option[String]] = column[Option[String]]("Remark", O.Length(200,varying=true), O.Default(None))
    /** Database column Status SqlType(INT), Default(Some(0)) */
    val status: Rep[Option[Int]] = column[Option[Int]]("Status", O.Default(Some(0)))
    /** Database column CreateTime SqlType(VARCHAR), Length(200,true), Default(None) */
    val createtime: Rep[Option[String]] = column[Option[String]]("CreateTime", O.Length(200,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table TLinkchannel */
  lazy val TLinkchannel = new TableQuery(tag => new TLinkchannel(tag))

  /** Entity class storing rows of table TLinkjump
   *  @param id Database column ID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param channelcode Database column ChannelCode SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param channelname Database column ChannelName SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param bankid Database column BankId SqlType(BIGINT), Default(None)
   *  @param bankname Database column BankName SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param fakeurl Database column FakeUrl SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param realurl Database column RealUrl SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param visitnum Database column VisitNum SqlType(BIGINT), Default(Some(0))
   *  @param createtime Database column CreateTime SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param status Database column Status SqlType(INT), Default(Some(0))
   *  @param remark Database column Remark SqlType(VARCHAR), Length(200,true), Default(None) */
  case class TLinkjumpRow(id: Long, channelcode: Option[String] = None, channelname: Option[String] = None, bankid: Option[Long] = None, bankname: Option[String] = None, fakeurl: Option[String] = None, realurl: Option[String] = None, visitnum: Option[Long] = Some(0L), createtime: Option[String] = None, status: Option[Int] = Some(0), remark: Option[String] = None)
  /** GetResult implicit for fetching TLinkjumpRow objects using plain SQL queries */
  implicit def GetResultTLinkjumpRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[Int]]): GR[TLinkjumpRow] = GR{
    prs => import prs._
    TLinkjumpRow.tupled((<<[Long], <<?[String], <<?[String], <<?[Long], <<?[String], <<?[String], <<?[String], <<?[Long], <<?[String], <<?[Int], <<?[String]))
  }
  /** Table description of table T_LinkJump. Objects of this class serve as prototypes for rows in queries. */
  class TLinkjump(_tableTag: Tag) extends Table[TLinkjumpRow](_tableTag, "T_LinkJump") {
    def * = (id, channelcode, channelname, bankid, bankname, fakeurl, realurl, visitnum, createtime, status, remark) <> (TLinkjumpRow.tupled, TLinkjumpRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), channelcode, channelname, bankid, bankname, fakeurl, realurl, visitnum, createtime, status, remark).shaped.<>({r=>import r._; _1.map(_=> TLinkjumpRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column ChannelCode SqlType(VARCHAR), Length(200,true), Default(None) */
    val channelcode: Rep[Option[String]] = column[Option[String]]("ChannelCode", O.Length(200,varying=true), O.Default(None))
    /** Database column ChannelName SqlType(VARCHAR), Length(200,true), Default(None) */
    val channelname: Rep[Option[String]] = column[Option[String]]("ChannelName", O.Length(200,varying=true), O.Default(None))
    /** Database column BankId SqlType(BIGINT), Default(None) */
    val bankid: Rep[Option[Long]] = column[Option[Long]]("BankId", O.Default(None))
    /** Database column BankName SqlType(VARCHAR), Length(200,true), Default(None) */
    val bankname: Rep[Option[String]] = column[Option[String]]("BankName", O.Length(200,varying=true), O.Default(None))
    /** Database column FakeUrl SqlType(VARCHAR), Length(200,true), Default(None) */
    val fakeurl: Rep[Option[String]] = column[Option[String]]("FakeUrl", O.Length(200,varying=true), O.Default(None))
    /** Database column RealUrl SqlType(VARCHAR), Length(200,true), Default(None) */
    val realurl: Rep[Option[String]] = column[Option[String]]("RealUrl", O.Length(200,varying=true), O.Default(None))
    /** Database column VisitNum SqlType(BIGINT), Default(Some(0)) */
    val visitnum: Rep[Option[Long]] = column[Option[Long]]("VisitNum", O.Default(Some(0L)))
    /** Database column CreateTime SqlType(VARCHAR), Length(50,true), Default(None) */
    val createtime: Rep[Option[String]] = column[Option[String]]("CreateTime", O.Length(50,varying=true), O.Default(None))
    /** Database column Status SqlType(INT), Default(Some(0)) */
    val status: Rep[Option[Int]] = column[Option[Int]]("Status", O.Default(Some(0)))
    /** Database column Remark SqlType(VARCHAR), Length(200,true), Default(None) */
    val remark: Rep[Option[String]] = column[Option[String]]("Remark", O.Length(200,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table TLinkjump */
  lazy val TLinkjump = new TableQuery(tag => new TLinkjump(tag))

  /** Entity class storing rows of table TLoanapply
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param atitle Database column Atitle SqlType(VARCHAR), Length(255,true), Default()
   *  @param title Database column Title SqlType(VARCHAR), Length(255,true), Default()
   *  @param logourl Database column LogoUrl SqlType(VARCHAR), Length(255,true), Default()
   *  @param applyurl Database column ApplyUrl SqlType(VARCHAR), Length(512,true), Default()
   *  @param state Database column State SqlType(TINYINT), Default(0)
   *  @param tag Database column Tag SqlType(VARCHAR), Length(255,true), Default()
   *  @param showall Database column ShowAll SqlType(TINYINT), Default(0)
   *  @param typeid Database column TypeId SqlType(BIGINT), Default(0)
   *  @param typename Database column TypeName SqlType(VARCHAR), Length(255,true), Default()
   *  @param createtime Database column CreateTime SqlType(TIMESTAMP)
   *  @param lastmodifytime Database column LastModifyTime SqlType(TIMESTAMP)
   *  @param orderindex Database column OrderIndex SqlType(INT), Default(0)
   *  @param thirdtype Database column ThirdType SqlType(INT), Default(0) */
  case class TLoanapplyRow(autoid: Long, atitle: String = "", title: String = "", logourl: String = "", applyurl: String = "", state: Byte = 0, tag: String = "", showall: Byte = 0, typeid: Long = 0L, typename: String = "", createtime: java.sql.Timestamp, lastmodifytime: java.sql.Timestamp, orderindex: Int = 0, thirdtype: Int = 0)
  /** GetResult implicit for fetching TLoanapplyRow objects using plain SQL queries */
  implicit def GetResultTLoanapplyRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Byte], e3: GR[java.sql.Timestamp], e4: GR[Int]): GR[TLoanapplyRow] = GR{
    prs => import prs._
    TLoanapplyRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[String], <<[Byte], <<[String], <<[Byte], <<[Long], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[Int], <<[Int]))
  }
  /** Table description of table T_LoanApply. Objects of this class serve as prototypes for rows in queries. */
  class TLoanapply(_tableTag: Tag) extends Table[TLoanapplyRow](_tableTag, "T_LoanApply") {
    def * = (autoid, atitle, title, logourl, applyurl, state, tag, showall, typeid, typename, createtime, lastmodifytime, orderindex, thirdtype) <> (TLoanapplyRow.tupled, TLoanapplyRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(atitle), Rep.Some(title), Rep.Some(logourl), Rep.Some(applyurl), Rep.Some(state), Rep.Some(tag), Rep.Some(showall), Rep.Some(typeid), Rep.Some(typename), Rep.Some(createtime), Rep.Some(lastmodifytime), Rep.Some(orderindex), Rep.Some(thirdtype)).shaped.<>({r=>import r._; _1.map(_=> TLoanapplyRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column Atitle SqlType(VARCHAR), Length(255,true), Default() */
    val atitle: Rep[String] = column[String]("Atitle", O.Length(255,varying=true), O.Default(""))
    /** Database column Title SqlType(VARCHAR), Length(255,true), Default() */
    val title: Rep[String] = column[String]("Title", O.Length(255,varying=true), O.Default(""))
    /** Database column LogoUrl SqlType(VARCHAR), Length(255,true), Default() */
    val logourl: Rep[String] = column[String]("LogoUrl", O.Length(255,varying=true), O.Default(""))
    /** Database column ApplyUrl SqlType(VARCHAR), Length(512,true), Default() */
    val applyurl: Rep[String] = column[String]("ApplyUrl", O.Length(512,varying=true), O.Default(""))
    /** Database column State SqlType(TINYINT), Default(0) */
    val state: Rep[Byte] = column[Byte]("State", O.Default(0))
    /** Database column Tag SqlType(VARCHAR), Length(255,true), Default() */
    val tag: Rep[String] = column[String]("Tag", O.Length(255,varying=true), O.Default(""))
    /** Database column ShowAll SqlType(TINYINT), Default(0) */
    val showall: Rep[Byte] = column[Byte]("ShowAll", O.Default(0))
    /** Database column TypeId SqlType(BIGINT), Default(0) */
    val typeid: Rep[Long] = column[Long]("TypeId", O.Default(0L))
    /** Database column TypeName SqlType(VARCHAR), Length(255,true), Default() */
    val typename: Rep[String] = column[String]("TypeName", O.Length(255,varying=true), O.Default(""))
    /** Database column CreateTime SqlType(TIMESTAMP) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column LastModifyTime SqlType(TIMESTAMP) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column OrderIndex SqlType(INT), Default(0) */
    val orderindex: Rep[Int] = column[Int]("OrderIndex", O.Default(0))
    /** Database column ThirdType SqlType(INT), Default(0) */
    val thirdtype: Rep[Int] = column[Int]("ThirdType", O.Default(0))
  }
  /** Collection-like TableQuery object for table TLoanapply */
  lazy val TLoanapply = new TableQuery(tag => new TLoanapply(tag))

  /** Entity class storing rows of table TLoantype
   *  @param typeid Database column TypeId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param typename Database column TypeName SqlType(VARCHAR), Length(255,true), Default()
   *  @param orderindex Database column OrderIndex SqlType(INT), Default(0)
   *  @param state Database column State SqlType(TINYINT), Default(0) */
  case class TLoantypeRow(typeid: Long, typename: String = "", orderindex: Int = 0, state: Byte = 0)
  /** GetResult implicit for fetching TLoantypeRow objects using plain SQL queries */
  implicit def GetResultTLoantypeRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[Byte]): GR[TLoantypeRow] = GR{
    prs => import prs._
    TLoantypeRow.tupled((<<[Long], <<[String], <<[Int], <<[Byte]))
  }
  /** Table description of table T_LoanType. Objects of this class serve as prototypes for rows in queries. */
  class TLoantype(_tableTag: Tag) extends Table[TLoantypeRow](_tableTag, "T_LoanType") {
    def * = (typeid, typename, orderindex, state) <> (TLoantypeRow.tupled, TLoantypeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(typeid), Rep.Some(typename), Rep.Some(orderindex), Rep.Some(state)).shaped.<>({r=>import r._; _1.map(_=> TLoantypeRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column TypeId SqlType(BIGINT), AutoInc, PrimaryKey */
    val typeid: Rep[Long] = column[Long]("TypeId", O.AutoInc, O.PrimaryKey)
    /** Database column TypeName SqlType(VARCHAR), Length(255,true), Default() */
    val typename: Rep[String] = column[String]("TypeName", O.Length(255,varying=true), O.Default(""))
    /** Database column OrderIndex SqlType(INT), Default(0) */
    val orderindex: Rep[Int] = column[Int]("OrderIndex", O.Default(0))
    /** Database column State SqlType(TINYINT), Default(0) */
    val state: Rep[Byte] = column[Byte]("State", O.Default(0))
  }
  /** Collection-like TableQuery object for table TLoantype */
  lazy val TLoantype = new TableQuery(tag => new TLoantype(tag))

  /** Entity class storing rows of table TPointAlipaychangecallback
   *  @param alipaychangeid Database column AlipaychangeId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param outTradeNo Database column out_trade_no SqlType(VARCHAR), Length(45,true)
   *  @param tradeNo Database column trade_no SqlType(VARCHAR), Length(45,true)
   *  @param fkDetailid Database column fk_detailid SqlType(BIGINT)
   *  @param changeamout Database column changeamout SqlType(INT) */
  case class TPointAlipaychangecallbackRow(alipaychangeid: Long, outTradeNo: String, tradeNo: String, fkDetailid: Long, changeamout: Int)
  /** GetResult implicit for fetching TPointAlipaychangecallbackRow objects using plain SQL queries */
  implicit def GetResultTPointAlipaychangecallbackRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int]): GR[TPointAlipaychangecallbackRow] = GR{
    prs => import prs._
    TPointAlipaychangecallbackRow.tupled((<<[Long], <<[String], <<[String], <<[Long], <<[Int]))
  }
  /** Table description of table T_Point_Alipaychangecallback. Objects of this class serve as prototypes for rows in queries. */
  class TPointAlipaychangecallback(_tableTag: Tag) extends Table[TPointAlipaychangecallbackRow](_tableTag, "T_Point_Alipaychangecallback") {
    def * = (alipaychangeid, outTradeNo, tradeNo, fkDetailid, changeamout) <> (TPointAlipaychangecallbackRow.tupled, TPointAlipaychangecallbackRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(alipaychangeid), Rep.Some(outTradeNo), Rep.Some(tradeNo), Rep.Some(fkDetailid), Rep.Some(changeamout)).shaped.<>({r=>import r._; _1.map(_=> TPointAlipaychangecallbackRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AlipaychangeId SqlType(BIGINT), AutoInc, PrimaryKey */
    val alipaychangeid: Rep[Long] = column[Long]("AlipaychangeId", O.AutoInc, O.PrimaryKey)
    /** Database column out_trade_no SqlType(VARCHAR), Length(45,true) */
    val outTradeNo: Rep[String] = column[String]("out_trade_no", O.Length(45,varying=true))
    /** Database column trade_no SqlType(VARCHAR), Length(45,true) */
    val tradeNo: Rep[String] = column[String]("trade_no", O.Length(45,varying=true))
    /** Database column fk_detailid SqlType(BIGINT) */
    val fkDetailid: Rep[Long] = column[Long]("fk_detailid")
    /** Database column changeamout SqlType(INT) */
    val changeamout: Rep[Int] = column[Int]("changeamout")

    /** Uniqueness Index over (tradeNo) (database name uk_trade_no) */
    val index1 = index("uk_trade_no", tradeNo, unique=true)
  }
  /** Collection-like TableQuery object for table TPointAlipaychangecallback */
  lazy val TPointAlipaychangecallback = new TableQuery(tag => new TPointAlipaychangecallback(tag))

  /** Entity class storing rows of table TPointAlipaynotify
   *  @param alipayid Database column AlipayId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param notifytime Database column notifytime SqlType(DATETIME)
   *  @param notifytype Database column notifytype SqlType(VARCHAR), Length(45,true)
   *  @param notifyid Database column notifyid SqlType(VARCHAR), Length(45,true)
   *  @param signtype Database column signtype SqlType(VARCHAR), Length(45,true)
   *  @param sign Database column sign SqlType(VARCHAR), Length(45,true)
   *  @param batchno Database column batchno SqlType(VARCHAR), Length(45,true)
   *  @param payusrid Database column payusrid SqlType(VARCHAR), Length(45,true)
   *  @param payusername Database column payusername SqlType(VARCHAR), Length(45,true)
   *  @param payuseraccountno Database column payuseraccountno SqlType(VARCHAR), Length(45,true)
   *  @param successdatas Database column successdatas SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param faildatas Database column faildatas SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param operatoruserid Database column operatoruserid SqlType(BIGINT)
   *  @param fkAskpickid Database column fk_askpickid SqlType(BIGINT) */
  case class TPointAlipaynotifyRow(alipayid: Long, notifytime: java.sql.Timestamp, notifytype: String, notifyid: String, signtype: String, sign: String, batchno: String, payusrid: String, payusername: String, payuseraccountno: String, successdatas: Option[String] = None, faildatas: Option[String] = None, operatoruserid: Long, fkAskpickid: Long)
  /** GetResult implicit for fetching TPointAlipaynotifyRow objects using plain SQL queries */
  implicit def GetResultTPointAlipaynotifyRow(implicit e0: GR[Long], e1: GR[java.sql.Timestamp], e2: GR[String], e3: GR[Option[String]]): GR[TPointAlipaynotifyRow] = GR{
    prs => import prs._
    TPointAlipaynotifyRow.tupled((<<[Long], <<[java.sql.Timestamp], <<[String], <<[String], <<[String], <<[String], <<[String], <<[String], <<[String], <<[String], <<?[String], <<?[String], <<[Long], <<[Long]))
  }
  /** Table description of table T_Point_Alipaynotify. Objects of this class serve as prototypes for rows in queries. */
  class TPointAlipaynotify(_tableTag: Tag) extends Table[TPointAlipaynotifyRow](_tableTag, "T_Point_Alipaynotify") {
    def * = (alipayid, notifytime, notifytype, notifyid, signtype, sign, batchno, payusrid, payusername, payuseraccountno, successdatas, faildatas, operatoruserid, fkAskpickid) <> (TPointAlipaynotifyRow.tupled, TPointAlipaynotifyRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(alipayid), Rep.Some(notifytime), Rep.Some(notifytype), Rep.Some(notifyid), Rep.Some(signtype), Rep.Some(sign), Rep.Some(batchno), Rep.Some(payusrid), Rep.Some(payusername), Rep.Some(payuseraccountno), successdatas, faildatas, Rep.Some(operatoruserid), Rep.Some(fkAskpickid)).shaped.<>({r=>import r._; _1.map(_=> TPointAlipaynotifyRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11, _12, _13.get, _14.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AlipayId SqlType(BIGINT), AutoInc, PrimaryKey */
    val alipayid: Rep[Long] = column[Long]("AlipayId", O.AutoInc, O.PrimaryKey)
    /** Database column notifytime SqlType(DATETIME) */
    val notifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("notifytime")
    /** Database column notifytype SqlType(VARCHAR), Length(45,true) */
    val notifytype: Rep[String] = column[String]("notifytype", O.Length(45,varying=true))
    /** Database column notifyid SqlType(VARCHAR), Length(45,true) */
    val notifyid: Rep[String] = column[String]("notifyid", O.Length(45,varying=true))
    /** Database column signtype SqlType(VARCHAR), Length(45,true) */
    val signtype: Rep[String] = column[String]("signtype", O.Length(45,varying=true))
    /** Database column sign SqlType(VARCHAR), Length(45,true) */
    val sign: Rep[String] = column[String]("sign", O.Length(45,varying=true))
    /** Database column batchno SqlType(VARCHAR), Length(45,true) */
    val batchno: Rep[String] = column[String]("batchno", O.Length(45,varying=true))
    /** Database column payusrid SqlType(VARCHAR), Length(45,true) */
    val payusrid: Rep[String] = column[String]("payusrid", O.Length(45,varying=true))
    /** Database column payusername SqlType(VARCHAR), Length(45,true) */
    val payusername: Rep[String] = column[String]("payusername", O.Length(45,varying=true))
    /** Database column payuseraccountno SqlType(VARCHAR), Length(45,true) */
    val payuseraccountno: Rep[String] = column[String]("payuseraccountno", O.Length(45,varying=true))
    /** Database column successdatas SqlType(VARCHAR), Length(100,true), Default(None) */
    val successdatas: Rep[Option[String]] = column[Option[String]]("successdatas", O.Length(100,varying=true), O.Default(None))
    /** Database column faildatas SqlType(VARCHAR), Length(100,true), Default(None) */
    val faildatas: Rep[Option[String]] = column[Option[String]]("faildatas", O.Length(100,varying=true), O.Default(None))
    /** Database column operatoruserid SqlType(BIGINT) */
    val operatoruserid: Rep[Long] = column[Long]("operatoruserid")
    /** Database column fk_askpickid SqlType(BIGINT) */
    val fkAskpickid: Rep[Long] = column[Long]("fk_askpickid")
  }
  /** Collection-like TableQuery object for table TPointAlipaynotify */
  lazy val TPointAlipaynotify = new TableQuery(tag => new TPointAlipaynotify(tag))

  /** Entity class storing rows of table TPointAskpick
   *  @param askpickid Database column AskPickId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param regularid Database column RegularId SqlType(INT)
   *  @param regularname Database column RegularName SqlType(VARCHAR), Length(45,true)
   *  @param userid Database column UserId SqlType(BIGINT)
   *  @param bankid Database column BankId SqlType(BIGINT)
   *  @param username Database column UserName SqlType(VARCHAR), Length(50,true)
   *  @param account Database column Account SqlType(VARCHAR), Length(50,true)
   *  @param amount Database column Amount SqlType(INT)
   *  @param accountbank Database column AccountBank SqlType(VARCHAR), Length(100,true)
   *  @param identitynum Database column IdentityNum SqlType(VARCHAR), Length(30,true)
   *  @param status Database column Status SqlType(INT)
   *  @param createtime Database column CreateTime SqlType(DATETIME)
   *  @param updatetime Database column UpdateTime SqlType(DATETIME) */
  case class TPointAskpickRow(askpickid: Long, regularid: Int, regularname: String, userid: Long, bankid: Long, username: String, account: String, amount: Int, accountbank: String, identitynum: String, status: Int, createtime: java.sql.Timestamp, updatetime: java.sql.Timestamp)
  /** GetResult implicit for fetching TPointAskpickRow objects using plain SQL queries */
  implicit def GetResultTPointAskpickRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[String], e3: GR[java.sql.Timestamp]): GR[TPointAskpickRow] = GR{
    prs => import prs._
    TPointAskpickRow.tupled((<<[Long], <<[Int], <<[String], <<[Long], <<[Long], <<[String], <<[String], <<[Int], <<[String], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_Point_AskPick. Objects of this class serve as prototypes for rows in queries. */
  class TPointAskpick(_tableTag: Tag) extends Table[TPointAskpickRow](_tableTag, "T_Point_AskPick") {
    def * = (askpickid, regularid, regularname, userid, bankid, username, account, amount, accountbank, identitynum, status, createtime, updatetime) <> (TPointAskpickRow.tupled, TPointAskpickRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(askpickid), Rep.Some(regularid), Rep.Some(regularname), Rep.Some(userid), Rep.Some(bankid), Rep.Some(username), Rep.Some(account), Rep.Some(amount), Rep.Some(accountbank), Rep.Some(identitynum), Rep.Some(status), Rep.Some(createtime), Rep.Some(updatetime)).shaped.<>({r=>import r._; _1.map(_=> TPointAskpickRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AskPickId SqlType(BIGINT), AutoInc, PrimaryKey */
    val askpickid: Rep[Long] = column[Long]("AskPickId", O.AutoInc, O.PrimaryKey)
    /** Database column RegularId SqlType(INT) */
    val regularid: Rep[Int] = column[Int]("RegularId")
    /** Database column RegularName SqlType(VARCHAR), Length(45,true) */
    val regularname: Rep[String] = column[String]("RegularName", O.Length(45,varying=true))
    /** Database column UserId SqlType(BIGINT) */
    val userid: Rep[Long] = column[Long]("UserId")
    /** Database column BankId SqlType(BIGINT) */
    val bankid: Rep[Long] = column[Long]("BankId")
    /** Database column UserName SqlType(VARCHAR), Length(50,true) */
    val username: Rep[String] = column[String]("UserName", O.Length(50,varying=true))
    /** Database column Account SqlType(VARCHAR), Length(50,true) */
    val account: Rep[String] = column[String]("Account", O.Length(50,varying=true))
    /** Database column Amount SqlType(INT) */
    val amount: Rep[Int] = column[Int]("Amount")
    /** Database column AccountBank SqlType(VARCHAR), Length(100,true) */
    val accountbank: Rep[String] = column[String]("AccountBank", O.Length(100,varying=true))
    /** Database column IdentityNum SqlType(VARCHAR), Length(30,true) */
    val identitynum: Rep[String] = column[String]("IdentityNum", O.Length(30,varying=true))
    /** Database column Status SqlType(INT) */
    val status: Rep[Int] = column[Int]("Status")
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column UpdateTime SqlType(DATETIME) */
    val updatetime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("UpdateTime")
  }
  /** Collection-like TableQuery object for table TPointAskpick */
  lazy val TPointAskpick = new TableQuery(tag => new TPointAskpick(tag))

  /** Entity class storing rows of table TPointAttache
   *  @param pointattacheid Database column PointAttacheId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column UserId SqlType(BIGINT)
   *  @param upoint Database column UPoint SqlType(BIGINT), Default(0)
   *  @param ubussinesscardurl Database column UBussinessCardUrl SqlType(VARCHAR), Length(200,true), Default() */
  case class TPointAttacheRow(pointattacheid: Long, userid: Long, upoint: Long = 0L, ubussinesscardurl: String = "")
  /** GetResult implicit for fetching TPointAttacheRow objects using plain SQL queries */
  implicit def GetResultTPointAttacheRow(implicit e0: GR[Long], e1: GR[String]): GR[TPointAttacheRow] = GR{
    prs => import prs._
    TPointAttacheRow.tupled((<<[Long], <<[Long], <<[Long], <<[String]))
  }
  /** Table description of table T_Point_Attache. Objects of this class serve as prototypes for rows in queries. */
  class TPointAttache(_tableTag: Tag) extends Table[TPointAttacheRow](_tableTag, "T_Point_Attache") {
    def * = (pointattacheid, userid, upoint, ubussinesscardurl) <> (TPointAttacheRow.tupled, TPointAttacheRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(pointattacheid), Rep.Some(userid), Rep.Some(upoint), Rep.Some(ubussinesscardurl)).shaped.<>({r=>import r._; _1.map(_=> TPointAttacheRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column PointAttacheId SqlType(BIGINT), AutoInc, PrimaryKey */
    val pointattacheid: Rep[Long] = column[Long]("PointAttacheId", O.AutoInc, O.PrimaryKey)
    /** Database column UserId SqlType(BIGINT) */
    val userid: Rep[Long] = column[Long]("UserId")
    /** Database column UPoint SqlType(BIGINT), Default(0) */
    val upoint: Rep[Long] = column[Long]("UPoint", O.Default(0L))
    /** Database column UBussinessCardUrl SqlType(VARCHAR), Length(200,true), Default() */
    val ubussinesscardurl: Rep[String] = column[String]("UBussinessCardUrl", O.Length(200,varying=true), O.Default(""))
  }
  /** Collection-like TableQuery object for table TPointAttache */
  lazy val TPointAttache = new TableQuery(tag => new TPointAttache(tag))

  /** Entity class storing rows of table TPointDetail
   *  @param pointdetailid Database column PointDetailId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column UserId SqlType(BIGINT)
   *  @param targetid Database column TargetId SqlType(BIGINT), Default(None)
   *  @param amount Database column Amount SqlType(INT)
   *  @param regularid Database column RegularId SqlType(INT)
   *  @param rinout Database column RInOut SqlType(INT)
   *  @param regularname Database column RegularName SqlType(VARCHAR), Length(20,true)
   *  @param remark Database column Remark SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TPointDetailRow(pointdetailid: Long, userid: Long, targetid: Option[Long] = None, amount: Int, regularid: Int, rinout: Int, regularname: String, remark: Option[String] = None, createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TPointDetailRow objects using plain SQL queries */
  implicit def GetResultTPointDetailRow(implicit e0: GR[Long], e1: GR[Option[Long]], e2: GR[Int], e3: GR[String], e4: GR[Option[String]], e5: GR[java.sql.Timestamp]): GR[TPointDetailRow] = GR{
    prs => import prs._
    TPointDetailRow.tupled((<<[Long], <<[Long], <<?[Long], <<[Int], <<[Int], <<[Int], <<[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_Point_Detail. Objects of this class serve as prototypes for rows in queries. */
  class TPointDetail(_tableTag: Tag) extends Table[TPointDetailRow](_tableTag, "T_Point_Detail") {
    def * = (pointdetailid, userid, targetid, amount, regularid, rinout, regularname, remark, createtime) <> (TPointDetailRow.tupled, TPointDetailRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(pointdetailid), Rep.Some(userid), targetid, Rep.Some(amount), Rep.Some(regularid), Rep.Some(rinout), Rep.Some(regularname), remark, Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TPointDetailRow.tupled((_1.get, _2.get, _3, _4.get, _5.get, _6.get, _7.get, _8, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column PointDetailId SqlType(BIGINT), AutoInc, PrimaryKey */
    val pointdetailid: Rep[Long] = column[Long]("PointDetailId", O.AutoInc, O.PrimaryKey)
    /** Database column UserId SqlType(BIGINT) */
    val userid: Rep[Long] = column[Long]("UserId")
    /** Database column TargetId SqlType(BIGINT), Default(None) */
    val targetid: Rep[Option[Long]] = column[Option[Long]]("TargetId", O.Default(None))
    /** Database column Amount SqlType(INT) */
    val amount: Rep[Int] = column[Int]("Amount")
    /** Database column RegularId SqlType(INT) */
    val regularid: Rep[Int] = column[Int]("RegularId")
    /** Database column RInOut SqlType(INT) */
    val rinout: Rep[Int] = column[Int]("RInOut")
    /** Database column RegularName SqlType(VARCHAR), Length(20,true) */
    val regularname: Rep[String] = column[String]("RegularName", O.Length(20,varying=true))
    /** Database column Remark SqlType(VARCHAR), Length(100,true), Default(None) */
    val remark: Rep[Option[String]] = column[Option[String]]("Remark", O.Length(100,varying=true), O.Default(None))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TPointDetail */
  lazy val TPointDetail = new TableQuery(tag => new TPointDetail(tag))

  /** Entity class storing rows of table TPointLlpcharge
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param bankcode Database column BankCode SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param dtorder Database column DtOrder SqlType(DATETIME)
   *  @param infoorder Database column InfoOrder SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param moneyorder Database column MoneyOrder SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param noorder Database column NoOrder SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param oidpaybill Database column OidPaybill SqlType(VARCHAR), Length(45,true)
   *  @param settledate Database column SettleDate SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param createtime Database column CreateTime SqlType(DATETIME)
   *  @param fkdetailid Database column FKDetailId SqlType(BIGINT) */
  case class TPointLlpchargeRow(autoid: Long, bankcode: Option[String] = None, dtorder: java.sql.Timestamp, infoorder: Option[String] = None, moneyorder: Option[String] = None, noorder: Option[String] = None, oidpaybill: String, settledate: Option[String] = None, createtime: java.sql.Timestamp, fkdetailid: Long)
  /** GetResult implicit for fetching TPointLlpchargeRow objects using plain SQL queries */
  implicit def GetResultTPointLlpchargeRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[java.sql.Timestamp], e3: GR[String]): GR[TPointLlpchargeRow] = GR{
    prs => import prs._
    TPointLlpchargeRow.tupled((<<[Long], <<?[String], <<[java.sql.Timestamp], <<?[String], <<?[String], <<?[String], <<[String], <<?[String], <<[java.sql.Timestamp], <<[Long]))
  }
  /** Table description of table T_Point_LLPCharge. Objects of this class serve as prototypes for rows in queries. */
  class TPointLlpcharge(_tableTag: Tag) extends Table[TPointLlpchargeRow](_tableTag, "T_Point_LLPCharge") {
    def * = (autoid, bankcode, dtorder, infoorder, moneyorder, noorder, oidpaybill, settledate, createtime, fkdetailid) <> (TPointLlpchargeRow.tupled, TPointLlpchargeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), bankcode, Rep.Some(dtorder), infoorder, moneyorder, noorder, Rep.Some(oidpaybill), settledate, Rep.Some(createtime), Rep.Some(fkdetailid)).shaped.<>({r=>import r._; _1.map(_=> TPointLlpchargeRow.tupled((_1.get, _2, _3.get, _4, _5, _6, _7.get, _8, _9.get, _10.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column BankCode SqlType(VARCHAR), Length(45,true), Default(None) */
    val bankcode: Rep[Option[String]] = column[Option[String]]("BankCode", O.Length(45,varying=true), O.Default(None))
    /** Database column DtOrder SqlType(DATETIME) */
    val dtorder: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("DtOrder")
    /** Database column InfoOrder SqlType(VARCHAR), Length(200,true), Default(None) */
    val infoorder: Rep[Option[String]] = column[Option[String]]("InfoOrder", O.Length(200,varying=true), O.Default(None))
    /** Database column MoneyOrder SqlType(VARCHAR), Length(100,true), Default(None) */
    val moneyorder: Rep[Option[String]] = column[Option[String]]("MoneyOrder", O.Length(100,varying=true), O.Default(None))
    /** Database column NoOrder SqlType(VARCHAR), Length(100,true), Default(None) */
    val noorder: Rep[Option[String]] = column[Option[String]]("NoOrder", O.Length(100,varying=true), O.Default(None))
    /** Database column OidPaybill SqlType(VARCHAR), Length(45,true) */
    val oidpaybill: Rep[String] = column[String]("OidPaybill", O.Length(45,varying=true))
    /** Database column SettleDate SqlType(VARCHAR), Length(45,true), Default(None) */
    val settledate: Rep[Option[String]] = column[Option[String]]("SettleDate", O.Length(45,varying=true), O.Default(None))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column FKDetailId SqlType(BIGINT) */
    val fkdetailid: Rep[Long] = column[Long]("FKDetailId")

    /** Uniqueness Index over (oidpaybill) (database name OidPaybill_UNIQUE) */
    val index1 = index("OidPaybill_UNIQUE", oidpaybill, unique=true)
  }
  /** Collection-like TableQuery object for table TPointLlpcharge */
  lazy val TPointLlpcharge = new TableQuery(tag => new TPointLlpcharge(tag))

  /** Entity class storing rows of table TPointRegula
   *  @param regularid Database column RegularId SqlType(INT), AutoInc, PrimaryKey
   *  @param rinout Database column RInOut SqlType(INT)
   *  @param regularname Database column RegularName SqlType(VARCHAR), Length(20,true)
   *  @param pointamount Database column PointAmount SqlType(INT)
   *  @param createtime Database column CreateTime SqlType(DATETIME)
   *  @param updatetime Database column UpdateTime SqlType(DATETIME) */
  case class TPointRegulaRow(regularid: Int, rinout: Int, regularname: String, pointamount: Int, createtime: java.sql.Timestamp, updatetime: java.sql.Timestamp)
  /** GetResult implicit for fetching TPointRegulaRow objects using plain SQL queries */
  implicit def GetResultTPointRegulaRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[TPointRegulaRow] = GR{
    prs => import prs._
    TPointRegulaRow.tupled((<<[Int], <<[Int], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_Point_Regula. Objects of this class serve as prototypes for rows in queries. */
  class TPointRegula(_tableTag: Tag) extends Table[TPointRegulaRow](_tableTag, "T_Point_Regula") {
    def * = (regularid, rinout, regularname, pointamount, createtime, updatetime) <> (TPointRegulaRow.tupled, TPointRegulaRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(regularid), Rep.Some(rinout), Rep.Some(regularname), Rep.Some(pointamount), Rep.Some(createtime), Rep.Some(updatetime)).shaped.<>({r=>import r._; _1.map(_=> TPointRegulaRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column RegularId SqlType(INT), AutoInc, PrimaryKey */
    val regularid: Rep[Int] = column[Int]("RegularId", O.AutoInc, O.PrimaryKey)
    /** Database column RInOut SqlType(INT) */
    val rinout: Rep[Int] = column[Int]("RInOut")
    /** Database column RegularName SqlType(VARCHAR), Length(20,true) */
    val regularname: Rep[String] = column[String]("RegularName", O.Length(20,varying=true))
    /** Database column PointAmount SqlType(INT) */
    val pointamount: Rep[Int] = column[Int]("PointAmount")
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column UpdateTime SqlType(DATETIME) */
    val updatetime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("UpdateTime")
  }
  /** Collection-like TableQuery object for table TPointRegula */
  lazy val TPointRegula = new TableQuery(tag => new TPointRegula(tag))

  /** Entity class storing rows of table TProvinceFull
   *  @param provinceid Database column ProvinceID SqlType(INT), PrimaryKey, Default(0)
   *  @param code Database column Code SqlType(VARCHAR), Length(6,true), Default()
   *  @param name Database column Name SqlType(VARCHAR), Length(50,true), Default()
   *  @param deletestatus Database column DeleteStatus SqlType(BIT) */
  case class TProvinceFullRow(provinceid: Int = 0, code: String = "", name: String = "", deletestatus: Boolean)
  /** GetResult implicit for fetching TProvinceFullRow objects using plain SQL queries */
  implicit def GetResultTProvinceFullRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean]): GR[TProvinceFullRow] = GR{
    prs => import prs._
    TProvinceFullRow.tupled((<<[Int], <<[String], <<[String], <<[Boolean]))
  }
  /** Table description of table T_Province_Full. Objects of this class serve as prototypes for rows in queries. */
  class TProvinceFull(_tableTag: Tag) extends Table[TProvinceFullRow](_tableTag, "T_Province_Full") {
    def * = (provinceid, code, name, deletestatus) <> (TProvinceFullRow.tupled, TProvinceFullRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(provinceid), Rep.Some(code), Rep.Some(name), Rep.Some(deletestatus)).shaped.<>({r=>import r._; _1.map(_=> TProvinceFullRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ProvinceID SqlType(INT), PrimaryKey, Default(0) */
    val provinceid: Rep[Int] = column[Int]("ProvinceID", O.PrimaryKey, O.Default(0))
    /** Database column Code SqlType(VARCHAR), Length(6,true), Default() */
    val code: Rep[String] = column[String]("Code", O.Length(6,varying=true), O.Default(""))
    /** Database column Name SqlType(VARCHAR), Length(50,true), Default() */
    val name: Rep[String] = column[String]("Name", O.Length(50,varying=true), O.Default(""))
    /** Database column DeleteStatus SqlType(BIT) */
    val deletestatus: Rep[Boolean] = column[Boolean]("DeleteStatus")
  }
  /** Collection-like TableQuery object for table TProvinceFull */
  lazy val TProvinceFull = new TableQuery(tag => new TProvinceFull(tag))

  /** Entity class storing rows of table TPushLog
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param userid Database column UserId SqlType(BIGINT)
   *  @param appid Database column AppId SqlType(INT)
   *  @param mess Database column Mess SqlType(VARCHAR), Length(500,true)
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TPushLogRow(autoid: Long, userid: Long, appid: Int, mess: String, createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TPushLogRow objects using plain SQL queries */
  implicit def GetResultTPushLogRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[String], e3: GR[java.sql.Timestamp]): GR[TPushLogRow] = GR{
    prs => import prs._
    TPushLogRow.tupled((<<[Long], <<[Long], <<[Int], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_Push_Log. Objects of this class serve as prototypes for rows in queries. */
  class TPushLog(_tableTag: Tag) extends Table[TPushLogRow](_tableTag, "T_Push_Log") {
    def * = (autoid, userid, appid, mess, createtime) <> (TPushLogRow.tupled, TPushLogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(userid), Rep.Some(appid), Rep.Some(mess), Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TPushLogRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column UserId SqlType(BIGINT) */
    val userid: Rep[Long] = column[Long]("UserId")
    /** Database column AppId SqlType(INT) */
    val appid: Rep[Int] = column[Int]("AppId")
    /** Database column Mess SqlType(VARCHAR), Length(500,true) */
    val mess: Rep[String] = column[String]("Mess", O.Length(500,varying=true))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TPushLog */
  lazy val TPushLog = new TableQuery(tag => new TPushLog(tag))

  /** Entity class storing rows of table TSmslog
   *  @param autoid Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param appid Database column AppID SqlType(INT), Default(0)
   *  @param mobile Database column Mobile SqlType(VARCHAR), Length(255,true), Default()
   *  @param content Database column Content SqlType(VARCHAR), Length(500,true), Default()
   *  @param createtime Database column CreateTime SqlType(DATETIME)
   *  @param lastmodifytime Database column LastModifyTime SqlType(DATETIME)
   *  @param result Database column Result SqlType(VARCHAR), Length(50,true), Default() */
  case class TSmslogRow(autoid: Long, appid: Int = 0, mobile: String = "", content: String = "", createtime: java.sql.Timestamp, lastmodifytime: java.sql.Timestamp, result: String = "")
  /** GetResult implicit for fetching TSmslogRow objects using plain SQL queries */
  implicit def GetResultTSmslogRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[String], e3: GR[java.sql.Timestamp]): GR[TSmslogRow] = GR{
    prs => import prs._
    TSmslogRow.tupled((<<[Long], <<[Int], <<[String], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String]))
  }
  /** Table description of table T_SmsLog. Objects of this class serve as prototypes for rows in queries. */
  class TSmslog(_tableTag: Tag) extends Table[TSmslogRow](_tableTag, "T_SmsLog") {
    def * = (autoid, appid, mobile, content, createtime, lastmodifytime, result) <> (TSmslogRow.tupled, TSmslogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(appid), Rep.Some(mobile), Rep.Some(content), Rep.Some(createtime), Rep.Some(lastmodifytime), Rep.Some(result)).shaped.<>({r=>import r._; _1.map(_=> TSmslogRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoID", O.AutoInc, O.PrimaryKey)
    /** Database column AppID SqlType(INT), Default(0) */
    val appid: Rep[Int] = column[Int]("AppID", O.Default(0))
    /** Database column Mobile SqlType(VARCHAR), Length(255,true), Default() */
    val mobile: Rep[String] = column[String]("Mobile", O.Length(255,varying=true), O.Default(""))
    /** Database column Content SqlType(VARCHAR), Length(500,true), Default() */
    val content: Rep[String] = column[String]("Content", O.Length(500,varying=true), O.Default(""))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column Result SqlType(VARCHAR), Length(50,true), Default() */
    val result: Rep[String] = column[String]("Result", O.Length(50,varying=true), O.Default(""))
  }
  /** Collection-like TableQuery object for table TSmslog */
  lazy val TSmslog = new TableQuery(tag => new TSmslog(tag))

  /** Entity class storing rows of table TStatuslog
   *  @param autoid Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param logtype Database column LogType SqlType(INT), Default(0)
   *  @param recordid Database column RecordID SqlType(BIGINT), Default(0)
   *  @param oldstatus Database column OldStatus SqlType(INT), Default(0)
   *  @param newstatus Database column NewStatus SqlType(INT), Default(0)
   *  @param userid Database column UserID SqlType(BIGINT), Default(0)
   *  @param bankid Database column BankID SqlType(BIGINT), Default(0)
   *  @param citycode Database column CityCode SqlType(VARCHAR), Length(50,true), Default()
   *  @param operatoruserid Database column OperatorUserID SqlType(BIGINT), Default(0)
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TStatuslogRow(autoid: Long, logtype: Int = 0, recordid: Long = 0L, oldstatus: Int = 0, newstatus: Int = 0, userid: Long = 0L, bankid: Long = 0L, citycode: String = "", operatoruserid: Long = 0L, createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TStatuslogRow objects using plain SQL queries */
  implicit def GetResultTStatuslogRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[String], e3: GR[java.sql.Timestamp]): GR[TStatuslogRow] = GR{
    prs => import prs._
    TStatuslogRow.tupled((<<[Long], <<[Int], <<[Long], <<[Int], <<[Int], <<[Long], <<[Long], <<[String], <<[Long], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_StatusLog. Objects of this class serve as prototypes for rows in queries. */
  class TStatuslog(_tableTag: Tag) extends Table[TStatuslogRow](_tableTag, "T_StatusLog") {
    def * = (autoid, logtype, recordid, oldstatus, newstatus, userid, bankid, citycode, operatoruserid, createtime) <> (TStatuslogRow.tupled, TStatuslogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(logtype), Rep.Some(recordid), Rep.Some(oldstatus), Rep.Some(newstatus), Rep.Some(userid), Rep.Some(bankid), Rep.Some(citycode), Rep.Some(operatoruserid), Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TStatuslogRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoID", O.AutoInc, O.PrimaryKey)
    /** Database column LogType SqlType(INT), Default(0) */
    val logtype: Rep[Int] = column[Int]("LogType", O.Default(0))
    /** Database column RecordID SqlType(BIGINT), Default(0) */
    val recordid: Rep[Long] = column[Long]("RecordID", O.Default(0L))
    /** Database column OldStatus SqlType(INT), Default(0) */
    val oldstatus: Rep[Int] = column[Int]("OldStatus", O.Default(0))
    /** Database column NewStatus SqlType(INT), Default(0) */
    val newstatus: Rep[Int] = column[Int]("NewStatus", O.Default(0))
    /** Database column UserID SqlType(BIGINT), Default(0) */
    val userid: Rep[Long] = column[Long]("UserID", O.Default(0L))
    /** Database column BankID SqlType(BIGINT), Default(0) */
    val bankid: Rep[Long] = column[Long]("BankID", O.Default(0L))
    /** Database column CityCode SqlType(VARCHAR), Length(50,true), Default() */
    val citycode: Rep[String] = column[String]("CityCode", O.Length(50,varying=true), O.Default(""))
    /** Database column OperatorUserID SqlType(BIGINT), Default(0) */
    val operatoruserid: Rep[Long] = column[Long]("OperatorUserID", O.Default(0L))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")

    /** Index over (createtime) (database name idx_CreateTime) */
    val index1 = index("idx_CreateTime", createtime)
  }
  /** Collection-like TableQuery object for table TStatuslog */
  lazy val TStatuslog = new TableQuery(tag => new TStatuslog(tag))

  /** Entity class storing rows of table TSysuser
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param realname Database column RealName SqlType(VARCHAR), Length(45,true), Default()
   *  @param username Database column UserName SqlType(VARCHAR), Length(40,true), Default()
   *  @param password Database column Password SqlType(VARCHAR), Length(100,true), Default()
   *  @param role Database column Role SqlType(INT), Default(0)
   *  @param createtime Database column CreateTime SqlType(DATETIME)
   *  @param lastmodifytime Database column LastModifyTime SqlType(DATETIME)
   *  @param state Database column State SqlType(INT), Default(1) */
  case class TSysuserRow(autoid: Long, realname: String = "", username: String = "", password: String = "", role: Int = 0, createtime: java.sql.Timestamp, lastmodifytime: java.sql.Timestamp, state: Int = 1)
  /** GetResult implicit for fetching TSysuserRow objects using plain SQL queries */
  implicit def GetResultTSysuserRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[java.sql.Timestamp]): GR[TSysuserRow] = GR{
    prs => import prs._
    TSysuserRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[Int]))
  }
  /** Table description of table T_SysUser. Objects of this class serve as prototypes for rows in queries. */
  class TSysuser(_tableTag: Tag) extends Table[TSysuserRow](_tableTag, "T_SysUser") {
    def * = (autoid, realname, username, password, role, createtime, lastmodifytime, state) <> (TSysuserRow.tupled, TSysuserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(realname), Rep.Some(username), Rep.Some(password), Rep.Some(role), Rep.Some(createtime), Rep.Some(lastmodifytime), Rep.Some(state)).shaped.<>({r=>import r._; _1.map(_=> TSysuserRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column RealName SqlType(VARCHAR), Length(45,true), Default() */
    val realname: Rep[String] = column[String]("RealName", O.Length(45,varying=true), O.Default(""))
    /** Database column UserName SqlType(VARCHAR), Length(40,true), Default() */
    val username: Rep[String] = column[String]("UserName", O.Length(40,varying=true), O.Default(""))
    /** Database column Password SqlType(VARCHAR), Length(100,true), Default() */
    val password: Rep[String] = column[String]("Password", O.Length(100,varying=true), O.Default(""))
    /** Database column Role SqlType(INT), Default(0) */
    val role: Rep[Int] = column[Int]("Role", O.Default(0))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column State SqlType(INT), Default(1) */
    val state: Rep[Int] = column[Int]("State", O.Default(1))

    /** Index over (username) (database name UK_TADMIN_USERNAME) */
    val index1 = index("UK_TADMIN_USERNAME", username)
  }
  /** Collection-like TableQuery object for table TSysuser */
  lazy val TSysuser = new TableQuery(tag => new TSysuser(tag))

  /** Entity class storing rows of table TTongjitrace
   *  @param autoid Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param stepid Database column StepID SqlType(INT), Default(0)
   *  @param appid Database column AppID SqlType(BIGINT), Default(0)
   *  @param plat Database column Plat SqlType(VARCHAR), Length(50,true), Default()
   *  @param macid Database column MacID SqlType(VARCHAR), Length(50,true), Default()
   *  @param udid Database column UdID SqlType(VARCHAR), Length(50,true), Default()
   *  @param selfid Database column SelfID SqlType(VARCHAR), Length(50,true), Default()
   *  @param userid Database column UserID SqlType(BIGINT), Default(0)
   *  @param devicetoken Database column DeviceToken SqlType(VARCHAR), Length(500,true), Default()
   *  @param platform Database column PlatForm SqlType(VARCHAR), Length(50,true), Default()
   *  @param channel Database column Channel SqlType(VARCHAR), Length(200,true), Default()
   *  @param clienttime Database column ClientTime SqlType(DATETIME)
   *  @param useragent Database column UserAgent SqlType(VARCHAR), Length(500,true), Default()
   *  @param locationhref Database column LocationHref SqlType(VARCHAR), Length(500,true), Default()
   *  @param ip Database column IP SqlType(VARCHAR), Length(50,true), Default()
   *  @param bigappid Database column BigAppID SqlType(BIGINT), Default(0)
   *  @param lastmodifytime Database column LastModifyTime SqlType(DATETIME)
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TTongjitraceRow(autoid: Long, stepid: Int = 0, appid: Long = 0L, plat: String = "", macid: String = "", udid: String = "", selfid: String = "", userid: Long = 0L, devicetoken: String = "", platform: String = "", channel: String = "", clienttime: java.sql.Timestamp, useragent: String = "", locationhref: String = "", ip: String = "", bigappid: Long = 0L, lastmodifytime: java.sql.Timestamp, createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TTongjitraceRow objects using plain SQL queries */
  implicit def GetResultTTongjitraceRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[String], e3: GR[java.sql.Timestamp]): GR[TTongjitraceRow] = GR{
    prs => import prs._
    TTongjitraceRow.tupled((<<[Long], <<[Int], <<[Long], <<[String], <<[String], <<[String], <<[String], <<[Long], <<[String], <<[String], <<[String], <<[java.sql.Timestamp], <<[String], <<[String], <<[String], <<[Long], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_TongJiTrace. Objects of this class serve as prototypes for rows in queries. */
  class TTongjitrace(_tableTag: Tag) extends Table[TTongjitraceRow](_tableTag, "T_TongJiTrace") {
    def * = (autoid, stepid, appid, plat, macid, udid, selfid, userid, devicetoken, platform, channel, clienttime, useragent, locationhref, ip, bigappid, lastmodifytime, createtime) <> (TTongjitraceRow.tupled, TTongjitraceRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(stepid), Rep.Some(appid), Rep.Some(plat), Rep.Some(macid), Rep.Some(udid), Rep.Some(selfid), Rep.Some(userid), Rep.Some(devicetoken), Rep.Some(platform), Rep.Some(channel), Rep.Some(clienttime), Rep.Some(useragent), Rep.Some(locationhref), Rep.Some(ip), Rep.Some(bigappid), Rep.Some(lastmodifytime), Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TTongjitraceRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoID SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoID", O.AutoInc, O.PrimaryKey)
    /** Database column StepID SqlType(INT), Default(0) */
    val stepid: Rep[Int] = column[Int]("StepID", O.Default(0))
    /** Database column AppID SqlType(BIGINT), Default(0) */
    val appid: Rep[Long] = column[Long]("AppID", O.Default(0L))
    /** Database column Plat SqlType(VARCHAR), Length(50,true), Default() */
    val plat: Rep[String] = column[String]("Plat", O.Length(50,varying=true), O.Default(""))
    /** Database column MacID SqlType(VARCHAR), Length(50,true), Default() */
    val macid: Rep[String] = column[String]("MacID", O.Length(50,varying=true), O.Default(""))
    /** Database column UdID SqlType(VARCHAR), Length(50,true), Default() */
    val udid: Rep[String] = column[String]("UdID", O.Length(50,varying=true), O.Default(""))
    /** Database column SelfID SqlType(VARCHAR), Length(50,true), Default() */
    val selfid: Rep[String] = column[String]("SelfID", O.Length(50,varying=true), O.Default(""))
    /** Database column UserID SqlType(BIGINT), Default(0) */
    val userid: Rep[Long] = column[Long]("UserID", O.Default(0L))
    /** Database column DeviceToken SqlType(VARCHAR), Length(500,true), Default() */
    val devicetoken: Rep[String] = column[String]("DeviceToken", O.Length(500,varying=true), O.Default(""))
    /** Database column PlatForm SqlType(VARCHAR), Length(50,true), Default() */
    val platform: Rep[String] = column[String]("PlatForm", O.Length(50,varying=true), O.Default(""))
    /** Database column Channel SqlType(VARCHAR), Length(200,true), Default() */
    val channel: Rep[String] = column[String]("Channel", O.Length(200,varying=true), O.Default(""))
    /** Database column ClientTime SqlType(DATETIME) */
    val clienttime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("ClientTime")
    /** Database column UserAgent SqlType(VARCHAR), Length(500,true), Default() */
    val useragent: Rep[String] = column[String]("UserAgent", O.Length(500,varying=true), O.Default(""))
    /** Database column LocationHref SqlType(VARCHAR), Length(500,true), Default() */
    val locationhref: Rep[String] = column[String]("LocationHref", O.Length(500,varying=true), O.Default(""))
    /** Database column IP SqlType(VARCHAR), Length(50,true), Default() */
    val ip: Rep[String] = column[String]("IP", O.Length(50,varying=true), O.Default(""))
    /** Database column BigAppID SqlType(BIGINT), Default(0) */
    val bigappid: Rep[Long] = column[Long]("BigAppID", O.Default(0L))
    /** Database column LastModifyTime SqlType(DATETIME) */
    val lastmodifytime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LastModifyTime")
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TTongjitrace */
  lazy val TTongjitrace = new TableQuery(tag => new TTongjitrace(tag))

  /** Entity class storing rows of table TTradeThird
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param tradeid Database column TradeId SqlType(BIGINT)
   *  @param thirdtradeid Database column ThirdTradeId SqlType(BIGINT)
   *  @param attacheuserid Database column AttacheUserId SqlType(BIGINT)
   *  @param ispay Database column IsPay SqlType(INT)
   *  @param channel Database column Channel SqlType(VARCHAR), Length(100,true)
   *  @param createtime Database column Createtime SqlType(DATETIME) */
  case class TTradeThirdRow(autoid: Long, tradeid: Long, thirdtradeid: Long, attacheuserid: Long, ispay: Int, channel: String, createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TTradeThirdRow objects using plain SQL queries */
  implicit def GetResultTTradeThirdRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[String], e3: GR[java.sql.Timestamp]): GR[TTradeThirdRow] = GR{
    prs => import prs._
    TTradeThirdRow.tupled((<<[Long], <<[Long], <<[Long], <<[Long], <<[Int], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_Trade_Third. Objects of this class serve as prototypes for rows in queries. */
  class TTradeThird(_tableTag: Tag) extends Table[TTradeThirdRow](_tableTag, "T_Trade_Third") {
    def * = (autoid, tradeid, thirdtradeid, attacheuserid, ispay, channel, createtime) <> (TTradeThirdRow.tupled, TTradeThirdRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), Rep.Some(tradeid), Rep.Some(thirdtradeid), Rep.Some(attacheuserid), Rep.Some(ispay), Rep.Some(channel), Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TTradeThirdRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column TradeId SqlType(BIGINT) */
    val tradeid: Rep[Long] = column[Long]("TradeId")
    /** Database column ThirdTradeId SqlType(BIGINT) */
    val thirdtradeid: Rep[Long] = column[Long]("ThirdTradeId")
    /** Database column AttacheUserId SqlType(BIGINT) */
    val attacheuserid: Rep[Long] = column[Long]("AttacheUserId")
    /** Database column IsPay SqlType(INT) */
    val ispay: Rep[Int] = column[Int]("IsPay")
    /** Database column Channel SqlType(VARCHAR), Length(100,true) */
    val channel: Rep[String] = column[String]("Channel", O.Length(100,varying=true))
    /** Database column Createtime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("Createtime")
  }
  /** Collection-like TableQuery object for table TTradeThird */
  lazy val TTradeThird = new TableQuery(tag => new TTradeThird(tag))

  /** Entity class storing rows of table TWelcomeTest
   *  @param autoid Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param title Database column Title SqlType(VARCHAR), Length(100,true), Default(Some())
   *  @param content Database column Content SqlType(VARCHAR), Length(255,true), Default(Some())
   *  @param remark Database column Remark SqlType(VARCHAR), Length(255,true), Default(Some())
   *  @param createtime Database column CreateTime SqlType(DATETIME) */
  case class TWelcomeTestRow(autoid: Long, title: Option[String] = Some(""), content: Option[String] = Some(""), remark: Option[String] = Some(""), createtime: java.sql.Timestamp)
  /** GetResult implicit for fetching TWelcomeTestRow objects using plain SQL queries */
  implicit def GetResultTWelcomeTestRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[java.sql.Timestamp]): GR[TWelcomeTestRow] = GR{
    prs => import prs._
    TWelcomeTestRow.tupled((<<[Long], <<?[String], <<?[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table T_Welcome_Test. Objects of this class serve as prototypes for rows in queries. */
  class TWelcomeTest(_tableTag: Tag) extends Table[TWelcomeTestRow](_tableTag, "T_Welcome_Test") {
    def * = (autoid, title, content, remark, createtime) <> (TWelcomeTestRow.tupled, TWelcomeTestRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(autoid), title, content, remark, Rep.Some(createtime)).shaped.<>({r=>import r._; _1.map(_=> TWelcomeTestRow.tupled((_1.get, _2, _3, _4, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AutoId SqlType(BIGINT), AutoInc, PrimaryKey */
    val autoid: Rep[Long] = column[Long]("AutoId", O.AutoInc, O.PrimaryKey)
    /** Database column Title SqlType(VARCHAR), Length(100,true), Default(Some()) */
    val title: Rep[Option[String]] = column[Option[String]]("Title", O.Length(100,varying=true), O.Default(Some("")))
    /** Database column Content SqlType(VARCHAR), Length(255,true), Default(Some()) */
    val content: Rep[Option[String]] = column[Option[String]]("Content", O.Length(255,varying=true), O.Default(Some("")))
    /** Database column Remark SqlType(VARCHAR), Length(255,true), Default(Some()) */
    val remark: Rep[Option[String]] = column[Option[String]]("Remark", O.Length(255,varying=true), O.Default(Some("")))
    /** Database column CreateTime SqlType(DATETIME) */
    val createtime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CreateTime")
  }
  /** Collection-like TableQuery object for table TWelcomeTest */
  lazy val TWelcomeTest = new TableQuery(tag => new TWelcomeTest(tag))
}
