package iccl.workshifts.m;

import java.util.ArrayList;
import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class ViewActivityAuto extends Activity implements OnClickListener, OnItemSelectedListener {
	public static ArrayList<View> UserworkView = new ArrayList<View>();
	public static ArrayList<View> pageView = new ArrayList<View>();
	private ArrayList<EditText> ed = new ArrayList<EditText>();
	private ArrayList<String> J = new ArrayList<String>();
	private ListView list;
	private ViewPager page;
	private Spinner spp, ac, mdm, mdr;
	private TextView day, work, user;
	private EditText max, auto_max_a, auto_max_b, auto_max_c, auto_max_d, auto_max_e;
	private TableRow tac, trm, tra, trb, trc, trd, tre;
	private ImageView yes, no;
	private int spp_mode = 1, ac_mode = 0, md_mode = 0, md_rule = 1, umax = 0;
	private int rule_0 = 0, rule_1 = 0, rule_2 = 0, rule_3 = 0, rule_4 = 0;
	private int fdy = DateUtils.getMonthDays(MainActivity.Years, MainActivity.Months);
	private boolean debug = true;
	private Boolean[] wwe = { false, false, false, false, false };

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.auto_view);
		findViewById();
		addTab();
		view_0();
		view_1();
		load();
		setView(this);
	}

	protected void onStart() {
		super.onStart();
	}

	protected void onPause() {
		super.onPause();
	}

	protected void onResume() {
		super.onResume();
	}

	protected void onDestroy() {
		super.onDestroy();
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
		}
		return false;
	}

	public void onClick(View v) {
		if (v == yes) {
			save();
		}
		if (v == no) {
			finish();
		}
	}

	private void findViewById() {
		page = (ViewPager) findViewById(R.id.auto_page);
		yes = (ImageView) findViewById(R.id.auto_yes);
		no = (ImageView) findViewById(R.id.auto_no);
	}

	@SuppressLint("InflateParams")
	@SuppressWarnings("static-access")
	private void addTab() {
		pageView.clear();
		LayoutInflater mInflater = getLayoutInflater().from(this);
		View v1 = mInflater.inflate(R.layout.auto_view_0, null);
		View v2 = mInflater.inflate(R.layout.auto_view_1, null);
		pageView.add(v1);
		pageView.add(v2);
		page.setAdapter(new MyPagerAdapter(pageView));
		page.setCurrentItem(0);
	}

	private void view_0() {
		day = (TextView) pageView.get(0).findViewById(R.id.auto_day);
		work = (TextView) pageView.get(0).findViewById(R.id.auto_work);
		user = (TextView) pageView.get(0).findViewById(R.id.auto_user);
		max = (EditText) pageView.get(0).findViewById(R.id.auto_max);
		auto_max_a = (EditText) pageView.get(0).findViewById(R.id.auto_max_a);
		auto_max_b = (EditText) pageView.get(0).findViewById(R.id.auto_max_b);
		auto_max_c = (EditText) pageView.get(0).findViewById(R.id.auto_max_c);
		auto_max_d = (EditText) pageView.get(0).findViewById(R.id.auto_max_d);
		auto_max_e = (EditText) pageView.get(0).findViewById(R.id.auto_max_e);
		trm = (TableRow) pageView.get(0).findViewById(R.id.auto_trm);
		tra = (TableRow) pageView.get(0).findViewById(R.id.auto_tra);
		trb = (TableRow) pageView.get(0).findViewById(R.id.auto_trb);
		trc = (TableRow) pageView.get(0).findViewById(R.id.auto_trc);
		trd = (TableRow) pageView.get(0).findViewById(R.id.auto_trd);
		tre = (TableRow) pageView.get(0).findViewById(R.id.auto_tre);
		tac = (TableRow) pageView.get(0).findViewById(R.id.auto_tac);
		spp = (Spinner) pageView.get(0).findViewById(R.id.auto_spp);
		ac = (Spinner) pageView.get(0).findViewById(R.id.auto_ac);
		mdm = (Spinner) pageView.get(0).findViewById(R.id.auto_mode);
		mdr = (Spinner) pageView.get(0).findViewById(R.id.auto_rule);
	}

	private void view_1() {
		list = (ListView) pageView.get(1).findViewById(R.id.auto_list);
		list.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
		list.setItemsCanFocus(true);
	}

	private void save() {
		int r0 = 0, r1 = 0, r2 = 0, r3 = 0, r4 = 0;
		ArrayList<String> autoWrite = new ArrayList<String>(); // �կZ�Ȧs
		ArrayList<String> autoMonth = new ArrayList<String>(); // ��ƯZ�Ȧs
		ArrayList<Integer> workMonth = new ArrayList<Integer>(); // ��ƯZ�֭p
		ArrayList<Integer> workDay = new ArrayList<Integer>(); // �s��W�Z��
		ArrayList<Integer> yesterday = new ArrayList<Integer>(); // �Q��Z��
		if (md_mode == 0) {
			umax = getInteger(max);
			String ds = MainActivity.Datelist.get(0);
			String ms = MainActivity.getLine(ds, 0, '/') + '/' + umax + '/';
			MainActivity.Datelist.set(0, ms);
			int uin = 1;
			String uip = user.getText().toString();
			if (!("".equals(uip) || "0".equals(uip))) {
				uin = Integer.parseInt(uip);
			}
			rule_0 = rule_0 / uin;
			rule_1 = umax;
			rule_2 = umax;
			rule_3 = umax;
			rule_4 = umax;
		} else {
			rule_0 = rule_0 / getInteger(auto_max_a);
			rule_1 = rule_1 / getInteger(auto_max_b);
			rule_2 = rule_2 / getInteger(auto_max_c);
			rule_3 = rule_3 / getInteger(auto_max_d);
			rule_4 = rule_4 / getInteger(auto_max_e);
		}
		for (int i = 0; i < ed.size(); i++) {
			int last = 0;
			String msg = ed.get(i).getText().toString();
			if (msg.length() != 0 && msg != null) {
				last = Integer.parseInt(msg);
			}
			workDay.add(last);
			workMonth.add(0);
			yesterday.add(99);
		}
		for (int k = 1; k <= fdy; k++) {
			// TODO 1~31
			ArrayList<Boolean> join = new ArrayList<Boolean>(); // �w��
			ArrayList<String> autoDay = new ArrayList<String>(); // ��ƯZ�Ȧs
			ArrayList<String> User = new ArrayList<String>(); // �H
			ArrayList<String> ARule = new ArrayList<String>(); // ��
			ArrayList<String> A = new ArrayList<String>(); // �կZ 08~17
			ArrayList<String> B = new ArrayList<String>(); // ���[ 08~20
			ArrayList<String> C = new ArrayList<String>(); // �p�] 17~02
			ArrayList<String> D = new ArrayList<String>(); // �]�[ 20~08
			ArrayList<String> E = new ArrayList<String>(); // �j�] 02~08
			ArrayList<String> F = new ArrayList<String>(); // ����
			ArrayList<String> P = new ArrayList<String>(); // Random

			String mmsg = MainActivity.Datelist.get(k);
			int run = 0;
			char key = '|';
			while (mmsg.indexOf(key, run) != -1) {
				String tmp = MainActivity.getLine(mmsg, run, key);
				run += tmp.length() + 1;
				if (tmp.substring(0, 1).equals("0")) {
					String wp = MainActivity.getLine(tmp, 1, '/');
					int wps = Integer.parseInt(wp);
					if (wps < MainActivity.Worklist.size()) {
						String rss = MainActivity.Worklist.get(wps);
						int r = 0;
						String na = MainActivity.getLine(rss, r, '|');
						r += na.length() + 1;
						String tp = MainActivity.getLine(rss, r, '|');
						if ("0".equals(tp)) {
							ARule.add(tmp);
						}
					}
				}
				if (tmp.substring(0, 1).equals("1")) {
					User.add(tmp);
				}
			}
			if (ARule.size() != 0) {
				ArrayList<String> ar = new ArrayList<String>();
				for (int ri = r0; ri < ARule.size(); ri++) {
					ar.add(ARule.get(ri));
				}
				for (int rj = 0; rj < r0; rj++) {
					ar.add(ARule.get(rj));
				}
				ARule.clear();
				r0++;
				if (r0 == ar.size()) {
					r0 = 0;
				}
				for (int rk = 0; rk < ar.size(); rk++) {
					ARule.add(ar.get(rk));
				}
			}
			for (int jo = 0; jo < ed.size(); jo++) {
				join.add(false);
			}
			for (int pp = 0; pp < MainActivity.Userlist.size(); pp++) {
				P.add("");
			}
			for (int u = 0; u < User.size(); u++) {
				String usb = User.get(u);
				String upb = MainActivity.getLine(usb, 1, '/'); // user.get(p);
				int ups = Integer.parseInt(upb);
				int mps = MainActivity.Userlist.size();
				if (ups < mps) {
					String nab = MainActivity.getLine(MainActivity.Userlist.get(ups), 0, '|');
					if (md_rule == 0) {
						P.set(RandomPath(nab), usb);
					} else {
						P.set(RegularPath(ups, ac_mode, mps), usb);
					}
				}
			}

			// �C�Ѫ��H
			for (int upp = 0; upp < P.size(); upp++) {
				String us = P.get(upp);
				if (us.length() > 0) {
					// MainActivity.out("g9/upp.. " + us);
					String up = MainActivity.getLine(us, 1, '/'); // user.get(p);
					String uss = MainActivity.Userlist.get(Integer.parseInt(up));
					String uc = us.substring(2 + up.length());
					String na = MainActivity.getLine(uss, 0, '|');
					if (uc.length() > 0) {
						// �կZ1 ���[1 �p�]1 �]�[1 �j�]1
						if ("00000".equals(uc)) {
							F.add(na);
						} else {
							for (int ui = 0; ui < uc.length(); ui++) {
								int si = Integer.parseInt(uc.substring(ui, ui + 1));
								if (si == 1) {
									switch (ui) {
									case 0:
										A.add(na);
										break;
									case 1:
										B.add(na);
										break;
									case 2:
										C.add(na);
										break;
									case 3:
										D.add(na);
										break;
									case 4:
										E.add(na);
										break;
									}
								}
							}
						}
					} else {
						MainActivity.toast(this, na + "�o�ͱƯZ���~!");
					}
				}
			}
			// �C�Ѫ��Z
			for (int w = 0; w < ARule.size(); w++) {
				String ws = ARule.get(w), na, tp, pp, st, et, mx;
				String wp = MainActivity.getLine(ws, 1, '/'); // work.get(p);
				int wps = Integer.parseInt(wp);
				if (wps < MainActivity.Worklist.size()) {
					String wss = MainActivity.Worklist.get(wps); // work.get(p).toString;
					String wc = ws.substring(2 + wp.length()); // other
					// �կZ�оǦ^�E1|1|08|11|
					int r = 0;
					na = MainActivity.getLine(wss, r, '|');
					r += na.length() + 1;
					tp = MainActivity.getLine(wss, r, '|');
					r += 2;
					pp = MainActivity.getLine(wss, r, '|');
					r += pp.length() + 1;
					st = MainActivity.getLine(wss, r, '|');
					r += st.length() + 1;
					et = MainActivity.getLine(wss, r, '|');
					r += et.length() + 1;
					mx = MainActivity.getLine(wss, r, '|');
					if (wc.length() > 0 && wc != null) {
						ArrayList<String> list = new ArrayList<String>();
						int wr = 0;
						char wk = '/';
						while (wc.indexOf(wk, wr) != -1) {
							String ctmp = MainActivity.getLine(wc, wr, wk);
							list.add(ctmp); // A||
							wr += ctmp.length() + 1;
						}
						for (int ci = 0; ci < list.size(); ci++) {
							String tmp = list.get(ci);
							String type = tmp.substring(0, 1);
							String msg = tmp.substring(1);
							switch (type) {
							case "0": // �W��
								na = msg;
								break;
							case "1": // �H��
								pp = msg;
								break;
							case "2": // �}�l
								st = msg;
								break;
							case "3": // ����
								et = msg;
								break;
							default:
								break;
							}
						}
					}
					// ����Z
					int ip = Integer.parseInt(tp);
					ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
					ArrayList<ArrayList<String>> backup = new ArrayList<ArrayList<String>>();
					if (ip == 0) {
						list.add(A);
						if (md_mode != 1) {
							list.add(B);
							list.add(C);
							list.add(D);
							list.add(E);
						}
						backup.add(A);
						backup.add(B);
						backup.add(C);
						backup.add(D);
						backup.add(E);
					} else if (ip == 1) {
						list.add(B);
						if (md_mode != 1) {
							list.add(A);
							list.add(C);
							list.add(D);
							list.add(E);
						}
						backup.add(B);
						backup.add(A);
						backup.add(C);
						backup.add(D);
						backup.add(E);
					} else if (ip == 2) {
						list.add(C);
						if (md_mode != 1) {
							list.add(D);
							list.add(E);
							list.add(A);
							list.add(B);
						}
						backup.add(C);
						backup.add(D);
						backup.add(E);
						backup.add(A);
						backup.add(B);
					} else if (ip == 3) {
						list.add(D);
						if (md_mode != 1) {
							list.add(E);
							list.add(C);
							list.add(A);
							list.add(B);
						}
						backup.add(D);
						backup.add(E);
						backup.add(C);
						backup.add(A);
						backup.add(B);
					} else {
						list.add(E);
						if (md_mode != 1) {
							list.add(D);
							list.add(B);
							list.add(A);
							list.add(C);
						}
						backup.add(E);
						backup.add(D);
						backup.add(B);
						backup.add(A);
						backup.add(C);
					}
					ArrayList<String> autoRule = new ArrayList<String>();
					// �ƯZ����
					for (int au = 0; au < list.size(); au++) {
						for (int aug = 0; aug < list.get(au).size(); aug++) {
							String sms = list.get(au).get(aug);
							if (addUs(sms, autoRule)) {
								autoRule.add(sms);
							}
						}
					}
					// backup����
					ArrayList<String> backRule = new ArrayList<String>();
					for (int bu = 0; bu < backup.size(); bu++) {
						for (int bug = 0; bug < backup.get(bu).size(); bug++) {
							String bms = backup.get(bu).get(bug);
							if (addUs(bms, backRule)) {
								backRule.add(bms);
								// MainActivity.out("g9/auto.."+autoUser.get(index));
							}
						}
					}
					
					int ipp = Integer.parseInt(pp); // �H��
					int imx = Integer.parseInt(mx); // �s�Z�W��
					for (int mp = 0; mp < ipp; mp++) {
						boolean adduser = false;
						ArrayList<String> ruleG1 = new ArrayList<String>(); // �Ըɤ@
						ArrayList<String> ruleG2 = new ArrayList<String>(); // �ԸɤG
						ArrayList<String> ruleG3 = new ArrayList<String>(); // �ԸɤT
						for (int wau = 0; wau < autoRule.size(); wau++) {
							int mmx = NameToMax(autoRule.get(wau));
							if (mmx == 0) {
								mmx = 99;
							}
							// TODO rule_0
							int mwd = workMonth.get(NameToPath(autoRule.get(wau)));
							if (mwd >= getAverage(ip, 3, 1) || mwd >= mmx) {
								// �[�J�ĤG���q�ԸɦW��
								ruleG1.add(autoRule.get(wau));
							} else {
								boolean inside = false;
								boolean overtime = false;
								boolean fatigue = false;

								// ��饼��
								for (int adt = 0; adt < autoDay.size(); adt++) {
									String adts = MainActivity.getLine(autoDay.get(adt), 1, '/');
									if (debug) {
										if (adts.equals(autoRule.get(wau))) {
											inside = true;
										}
									} else {
										if (PathToName(Integer.parseInt(adts)).equals(autoRule.get(wau))) {
											inside = true;
										}
									}
								}

								if (!inside) {
									// �s��W�Z�ˬd
									// umx �ϥΪ̤w�s�Z�W��
									// imx �u�@���w�s�Z�W��
									int umx = workDay.get(NameToPath(autoRule.get(wau)));
									if (umx >= imx) {
										overtime = true;
									}
								}

								if (!inside && !overtime) {
									// �Q��W�Z�ˬd
									int up = yesterday.get(NameToPath(autoRule.get(wau)));
									if (up != 99) {
										if (ip != up) {
											fatigue = true;
										}
									}
								}
								if (!inside && !overtime && !fatigue) {// �s��
									adduser = true;
									int wmi = workMonth.get(NameToPath(autoRule.get(wau))) + 1;
									int wdi = workDay.get(NameToPath(autoRule.get(wau))) + 1;
									join.set(NameToPath(autoRule.get(wau)), true); // ���W�Z
									workMonth.set(NameToPath(autoRule.get(wau)), wmi); // ��Z��+1
									workDay.set(NameToPath(autoRule.get(wau)), wdi); // �s��W�Z+1
									yesterday.set(NameToPath(autoRule.get(wau)), ip); // �Q��Z��
									if (debug) {
										autoDay.add("2" + autoRule.get(wau) + '/' + ws.substring(1) + '|'); // ����
									} else {
										autoDay.add("2" + NameToPath(autoRule.get(wau)) + '/' + ws.substring(1) + '|'); // ����
									}
									break;
								}
							}
						}
						if (!adduser) {
							for (int wau = 0; wau < ruleG1.size(); wau++) {
								int mxx = NameToMax(ruleG1.get(wau));
								if (mxx == 0) {
									mxx = 99;
								}
								// TODO (rule_0 + 1)
								int mwd = workMonth.get(NameToPath(ruleG1.get(wau)));
								if (mwd >= (getAverage(ip, 3, 2)) || mwd >= (mxx)) {
									ruleG2.add(ruleG1.get(wau));
								} else {
									boolean inside = false;
									boolean overtime = false;
									boolean fatigue = false;
									// ��饼��
									for (int adt = 0; adt < autoDay.size(); adt++) {
										String adts = MainActivity.getLine(autoDay.get(adt), 1, '/');
										if (debug) {
											if (adts.equals(ruleG1.get(wau))) {
												inside = true;
											}
										} else {
											if (PathToName(Integer.parseInt(adts)).equals(ruleG1.get(wau))) {
												inside = true;
											}
										}
									}

									if (!inside) {
										// �s��W�Z�ˬd
										// umx �ϥΪ̤w�s�Z�W��
										// imx �u�@���w�s�Z�W��
										int umx = workDay.get(NameToPath(ruleG1.get(wau)));
										if (umx >= imx) {
											overtime = true;
										}
									}

									if (!inside && !overtime) {
										// �Q��W�Z�ˬd
										int up = yesterday.get(NameToPath(ruleG1.get(wau)));
										if (up != 99) {
											if (ip != up) {
												fatigue = true;
											}
										}
									}

									if (!inside && !overtime && !fatigue) {// �s��
										adduser = true;
										int wmi = workMonth.get(NameToPath(ruleG1.get(wau))) + 1;
										int wdi = workDay.get(NameToPath(ruleG1.get(wau))) + 1;
										join.set(NameToPath(ruleG1.get(wau)), true); // ���W�Z
										workMonth.set(NameToPath(ruleG1.get(wau)), wmi); // ��Z��+1
										workDay.set(NameToPath(ruleG1.get(wau)), wdi); // �s��W�Z+1
										yesterday.set(NameToPath(ruleG1.get(wau)), ip); // �Q��Z��
										if (debug) {
											autoDay.add("2" + ruleG1.get(wau) + '/' + ws.substring(1) + '|'); // ����
										} else {
											autoDay.add(
													"2" + NameToPath(ruleG1.get(wau)) + '/' + ws.substring(1) + '|'); // ����
										}
										break;
									}
								}
							}
						}
						if (!adduser) {
							for (int eau = 0; eau < ruleG2.size(); eau++) {
								int mxx = NameToMax(ruleG2.get(eau));
								if (mxx == 0) {
									mxx = 99;
								}
								// TODO (umax + 1)
								int mwd = workMonth.get(NameToPath(ruleG2.get(eau)));
								if (mwd >= (getAverage(ip, 1, 1)) || mwd >= (mxx)) {
									ruleG3.add(ruleG2.get(eau));
								} else {
									boolean inside = false;
									boolean overtime = false;
									boolean fatigue = false;

									// ��饼��
									for (int adt = 0; adt < autoDay.size(); adt++) {
										String adts = MainActivity.getLine(autoDay.get(adt), 1, '/');
										if (debug) {
											if (adts.equals(ruleG2.get(eau))) {
												inside = true;
											}
										} else {
											if (PathToName(Integer.parseInt(adts)).equals(ruleG2.get(eau))) {
												inside = true;
											}
										}
									}

									if (!inside) {
										// �s��W�Z�ˬd
										// umx �ϥΪ̤w�s�Z�W��
										// imx �u�@���w�s�Z�W��
										int umx = workDay.get(NameToPath(ruleG2.get(eau)));
										if (umx >= imx) {
											overtime = true;
										}
									}

									if (!inside && !overtime) {
										// �Q��W�Z�ˬd
										int up = yesterday.get(NameToPath(ruleG2.get(eau)));
										if (up != 99) {
											if (ip == 0) {
												// �կZ
												if (up == 2 || up == 3 || up == 4) {
													// ���W�p�],�]�[,�j�]
													fatigue = true;
												}
											} else if (ip == 1) {
												// ���[
												if (up == 2 || up == 3) {
													// ���W�p�],�]�[
													fatigue = true;
												}
											} else if (ip == 2) {
												// �p�]
												if (up == 3 || up == 4) {
													// ���W�]�[,�j�]
													fatigue = true;
												}
											} else if (ip == 3) {
												// �]�[
												if (up == 0 || up == 1) {
													// ���W�կZ,���[
													fatigue = true;
												}
											} else {
												// �j�]
												if (up == 0 || up == 1) {
													// ���W�կZ,���[
													fatigue = true;
												}
											}
										}
									}

									if (!inside && !overtime && !fatigue) {
										adduser = true;
										int wmi = workMonth.get(NameToPath(ruleG2.get(eau))) + 1;
										int wdi = workDay.get(NameToPath(ruleG2.get(eau))) + 1;
										join.set(NameToPath(ruleG2.get(eau)), true); // ���W�Z
										workMonth.set(NameToPath(ruleG2.get(eau)), wmi); // ��Z��+1
										workDay.set(NameToPath(ruleG2.get(eau)), wdi); // �s��W�Z+1
										yesterday.set(NameToPath(ruleG2.get(eau)), ip); // �Q��Z��
										if (debug) {
											autoDay.add("2" + ruleG2.get(eau) + '/' + ws.substring(1) + '|'); // ����
										} else {
											autoDay.add(
													"2" + NameToPath(ruleG2.get(eau)) + '/' + ws.substring(1) + '|'); // ����
										}
										break;
									}
								}
							}
						}
						if (!adduser) {
							if (spp_mode == 0) {
								while (ruleG3.size() != 0) {
									int ng = new Random().nextInt(ruleG3.size());
									int x = NameToMax(ruleG3.get(ng));
									if (x == 0) {
										x = 99;
									}
									int mwd = workMonth.get(NameToPath(ruleG3.get(ng))) - 1;
									// TODO �L�k�ƯZ�B�z
									if (mwd >= getAverage(ip, 1, 1) || mwd >= x) {
										ruleG3.remove(ng);
									} else {
										boolean inside = false;
										boolean overtime = false;
										boolean fatigue = false;

										// ��饼��
										for (int adt = 0; adt < autoDay.size(); adt++) {
											String adts = MainActivity.getLine(autoDay.get(adt), 1, '/');
											if (debug) {
												if (adts.equals(ruleG3.get(ng))) {
													inside = true;
												}
											} else {
												if (PathToName(Integer.parseInt(adts)).equals(ruleG3.get(ng))) {
													inside = true;
												}
											}
										}
										// �s��W�Z�ˬd
										if (!inside) {
											// umx �ϥΪ̤w�s�Z�W��
											// imx �u�@���w�s�Z�W��
											int umx = workDay.get(NameToPath(ruleG3.get(ng)));
											if (umx >= imx) {
												overtime = true;
											}
										}
										// �Q��W�Z�ˬd
										if (!inside && !overtime) {
											int up = yesterday.get(NameToPath(ruleG3.get(ng)));
											if (up != 99) {
												if (ip == 0) {
													// �կZ
													if (up == 2 || up == 3 || up == 4) {
														// ���W�p�],�]�[,�j�]
														fatigue = true;
													}
												} else if (ip == 1) {
													// ���[
													if (up == 2 || up == 3) {
														// ���W�p�],�]�[
														fatigue = true;
													}
												} else if (ip == 2) {
													// �p�]
													if (up == 3 || up == 4) {
														// ���W�]�[,�j�]
														fatigue = true;
													}
												} else if (ip == 3) {
													// �]�[
													if (up == 0 || up == 1) {
														// ���W�կZ,���[
														fatigue = true;
													}
												} else {
													// �j�]
													if (up == 0 || up == 1) {
														// ���W�կZ,���[
														fatigue = true;
													}
												}
											}
										}
										if (!inside && !overtime && !fatigue) {
											adduser = true;
											int wmi = workMonth.get(NameToPath(ruleG3.get(ng))) + 1;
											int wdi = workDay.get(NameToPath(ruleG3.get(ng))) + 1;
											join.set(NameToPath(ruleG3.get(ng)), true); // ���W�Z
											workMonth.set(NameToPath(ruleG3.get(ng)), wmi); // ��Z��+1
											workDay.set(NameToPath(ruleG3.get(ng)), wdi); // �s��W�Z+1
											yesterday.set(NameToPath(ruleG3.get(ng)), ip); // �Q��Z��
											if (debug) {
												autoDay.add("2" + ruleG3.get(ng) + '/' + ws.substring(1) + '|'); // ����
											} else {
												autoDay.add(
														"2" + NameToPath(ruleG3.get(ng)) + '/' + ws.substring(1) + '|'); // ����
											}
											break;
										} else {
											ruleG3.remove(ng);
										}
									}
								}
							}
						}
						if (!adduser) {
							autoDay.add("299/" + ws.substring(1) + '|');
							MainActivity.RedPoint.add(new GetPoint(MainActivity.Years, (MainActivity.Months + 1), k));
						}
					}
				}
			}
			// ��
			for (int ji = 0; ji < join.size(); ji++) {
				if (!join.get(ji)) {
					workDay.set(ji, 0);
					yesterday.set(ji, 99);
				}
			}
			// ��s
			String sadm = "";
			for (int adm = 0; adm < autoDay.size(); adm++) {
				sadm += autoDay.get(adm);
			}
			autoWrite.add(sadm);
		}
		for (

		int id = 0; id < ed.size(); id++) {
			int last = 0;
			String msg = ed.get(id).getText().toString();
			if (msg.length() != 0 && msg != null) {
				last = Integer.parseInt(msg);
			}
			workDay.set(id, last);
			yesterday.set(id, 99);
		}
		for (int j = 1; j <= fdy; j++) {
			// TODO 1~31
			// msg += 0 + "" + i + "/0��/12/26/319/4|"; �կZ,����,�p�],�]�[,�j�]
			// msg += 1 + "" + i + "/11111|";
			ArrayList<Boolean> join = new ArrayList<Boolean>(); // �w��
			ArrayList<String> autoDay = new ArrayList<String>(); // ��ƯZ�Ȧs
			ArrayList<String> User = new ArrayList<String>(); // �H
			ArrayList<String> Work = new ArrayList<String>(); // �Z
			ArrayList<String> ARule = new ArrayList<String>(); //
			ArrayList<String> FRule = new ArrayList<String>(); //
			ArrayList<String> BRule = new ArrayList<String>(); // ���[
			ArrayList<String> CRule = new ArrayList<String>(); // �p�]
			ArrayList<String> DRule = new ArrayList<String>(); // �]�[
			ArrayList<String> ERule = new ArrayList<String>(); // �j�]
			ArrayList<String> A = new ArrayList<String>(); // �կZ 08~17
			ArrayList<String> B = new ArrayList<String>(); // ���[ 08~20
			ArrayList<String> C = new ArrayList<String>(); // �p�] 17~02
			ArrayList<String> D = new ArrayList<String>(); // �]�[ 20~08
			ArrayList<String> E = new ArrayList<String>(); // �j�] 02~08
			ArrayList<String> F = new ArrayList<String>(); // ����
			ArrayList<String> I = new ArrayList<String>(); // User��s
			ArrayList<String> P = new ArrayList<String>(); // Random

			String mmsg = MainActivity.Datelist.get(j);
			int run = 0;
			char key = '|';
			while (mmsg.indexOf(key, run) != -1) {
				String tmp = MainActivity.getLine(mmsg, run, key);
				run += tmp.length() + 1;
				if (tmp.substring(0, 1).equals("0")) {
					String wp = MainActivity.getLine(tmp, 1, '/');
					int wps = Integer.parseInt(wp);
					if (wps < MainActivity.Worklist.size()) {
						String rss = MainActivity.Worklist.get(wps);
						int r = 0;
						String na = MainActivity.getLine(rss, r, '|');
						r += na.length() + 1;
						String tp = MainActivity.getLine(rss, r, '|');
						if ("1".equals(tp)) {
							BRule.add(tmp);
						}
						if ("2".equals(tp)) {
							CRule.add(tmp);
						}
						if ("3".equals(tp)) {
							DRule.add(tmp);
						}
						if ("4".equals(tp)) {
							ERule.add(tmp);
						}
					}
				}
				if (tmp.substring(0, 1).equals("1")) {
					User.add(tmp);
				}
			}
			String awsg = autoWrite.get(j - 1), ssl = "";
			if (j < autoWrite.size()) {
				ssl = autoWrite.get(j);
			}
			run = 0;
			while (awsg.indexOf(key, run) != -1) {
				String tmp = MainActivity.getLine(awsg, run, key);
				run += tmp.length() + 1;
				ARule.add(tmp + key);
			}
			run = 0;
			while (ssl.indexOf(key, run) != -1) {
				String tmpa = MainActivity.getLine(ssl, run, key);
				run += tmpa.length() + 1;
				FRule.add(tmpa + key);
			}

			// ----------------
			if (BRule.size() != 0) {
				ArrayList<String> br = new ArrayList<String>();
				for (int ri = r1; ri < BRule.size(); ri++) {
					br.add(BRule.get(ri));
				}
				for (int rj = 0; rj < r1; rj++) {
					br.add(BRule.get(rj));
				}
				r1++;
				if (r1 == br.size()) {
					r1 = 0;
				}
				for (int rk = 0; rk < br.size(); rk++) {
					Work.add(br.get(rk));
				}
			}
			// ----------------
			if (CRule.size() != 0) {
				ArrayList<String> cr = new ArrayList<String>();
				for (int ri = r2; ri < CRule.size(); ri++) {
					cr.add(CRule.get(ri));
				}
				for (int rj = 0; rj < r2; rj++) {
					cr.add(CRule.get(rj));
				}
				r2++;
				if (r2 == CRule.size()) {
					r2 = 0;
				}
				for (int rk = 0; rk < CRule.size(); rk++) {
					Work.add(cr.get(rk));
				}
			}
			// ----------------
			if (DRule.size() != 0) {
				ArrayList<String> dr = new ArrayList<String>();
				for (int ri = r3; ri < DRule.size(); ri++) {
					dr.add(DRule.get(ri));
				}
				for (int rj = 0; rj < r3; rj++) {
					dr.add(DRule.get(rj));
				}
				r3++;
				if (r3 == DRule.size()) {
					r3 = 0;
				}
				for (int rk = 0; rk < DRule.size(); rk++) {
					Work.add(dr.get(rk));
				}
			}
			// ----------------
			if (ERule.size() != 0) {
				ArrayList<String> er = new ArrayList<String>();
				for (int ri = r4; ri < ERule.size(); ri++) {
					er.add(ERule.get(ri));
				}
				for (int rj = 0; rj < r4; rj++) {
					er.add(ERule.get(rj));
				}
				r4++;
				if (r4 == ERule.size()) {
					r4 = 0;
				}

				for (int rk = 0; rk < ERule.size(); rk++) {
					Work.add(er.get(rk));
				}
			}
			// ----------------
			for (int jo = 0; jo < ed.size(); jo++) {
				join.add(false);
			}

			if (Work.size() != 0 && User.size() != 0) {
				// �C�Ѫ��H
				for (int pp = 0; pp < MainActivity.Userlist.size(); pp++) {
					P.add("");
				}
				for (int u = 0; u < User.size(); u++) {
					String usb = User.get(u);
					String upb = MainActivity.getLine(usb, 1, '/'); // user.get(p);
					int ups = Integer.parseInt(upb);
					int mps = MainActivity.Userlist.size();
					if (ups < mps) {
						String nab = MainActivity.getLine(MainActivity.Userlist.get(ups), 0, '|');
						if (md_rule == 0) {
							P.set(RandomPath(nab), usb);
						} else {
							P.set(RegularPath(ups, ac_mode, mps), usb);
						}
					}
				}
				for (int upp = 0; upp < P.size(); upp++) {
					// ����
					String us = P.get(upp);
					if (us.length() > 0) {
						// MainActivity.out("g9/upp.. " + us);
						String up = MainActivity.getLine(us, 1, '/'); // user.get(p);
						String uss = MainActivity.Userlist.get(Integer.parseInt(up));
						String uc = us.substring(2 + up.length());
						String na = MainActivity.getLine(uss, 0, '|');
						if (uc.length() > 0) {
							// �կZ1 ���[1 �p�]1 �]�[1 �j�]1
							if (uc.equals("00000")) {
								F.add(na);
							} else {
								for (int ui = 0; ui < uc.length(); ui++) {
									int si = Integer.parseInt(uc.substring(ui, ui + 1));
									if (si == 1) {
										switch (ui) {
										case 0:
											A.add(na);
											break;
										case 1:
											B.add(na);
											break;
										case 2:
											C.add(na);
											break;
										case 3:
											D.add(na);
											break;
										case 4:
											E.add(na);
											break;
										}
									}
								}
							}
						} else {
							MainActivity.toast(this, na + "�o�ͱƯZ���~!");
						}
					}
				}

				for (int ape = 0; ape < ARule.size(); ape++) {
					autoDay.add(ARule.get(ape));
					String shap = MainActivity.getLine(ARule.get(ape), 1, '/');
					if (!"99".equals(shap)) {
						int wadi = workDay.get(NameToPath(shap)) + 1;
						join.set(NameToPath(shap), true); // ���W�Z
						workDay.set(NameToPath(shap), wadi); // �s��W�Z+1
						yesterday.set(NameToPath(shap), 0); // �Q��Z��
					}
				}

				for (int afe = 0; afe < FRule.size(); afe++) {
					String sfap = MainActivity.getLine(FRule.get(afe), 1, '/');
					if (!"99".equals(sfap)) {
						int wdi = workDay.get(NameToPath(sfap)) + 1;
						workDay.set(NameToPath(sfap), wdi); // �s��W�Z+1
					}
				}

				// �C�Ѫ��Z
				for (int w = 0; w < Work.size(); w++) {
					String ws = Work.get(w), na, tp, pp, st, et, mx;
					String wp = MainActivity.getLine(ws, 1, '/'); // work.get(p);
					int wps = Integer.parseInt(wp);
					if (wps < MainActivity.Worklist.size()) {
						String wss = MainActivity.Worklist.get(wps); // work.get(p).toString;
						String wc = ws.substring(2 + wp.length()); // other
						// �կZ�оǦ^�E1|1|08|11|
						int r = 0;
						na = MainActivity.getLine(wss, r, '|');
						r += na.length() + 1;
						tp = MainActivity.getLine(wss, r, '|');
						r += 2;
						pp = MainActivity.getLine(wss, r, '|');
						r += pp.length() + 1;
						st = MainActivity.getLine(wss, r, '|');
						r += st.length() + 1;
						et = MainActivity.getLine(wss, r, '|');
						r += et.length() + 1;
						mx = MainActivity.getLine(wss, r, '|');
						if (wc.length() > 0 && wc != null) {
							ArrayList<String> list = new ArrayList<String>();
							int wr = 0;
							char wk = '/';
							while (wc.indexOf(wk, wr) != -1) {
								String ctmp = MainActivity.getLine(wc, wr, wk);
								list.add(ctmp); // A||
								wr += ctmp.length() + 1;
							}
							for (int ci = 0; ci < list.size(); ci++) {
								String tmp = list.get(ci);
								String type = tmp.substring(0, 1);
								String msg = tmp.substring(1);
								switch (type) {
								case "0": // �W��
									na = msg;
									break;
								case "1": // �H��
									pp = msg;
									break;
								case "2": // �}�l
									st = msg;
									break;
								case "3": // ����
									et = msg;
									break;
								default:
									break;
								}
							}
						}
						// ����Z
						int ip = Integer.parseInt(tp);
						ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
						ArrayList<ArrayList<String>> backup = new ArrayList<ArrayList<String>>();
						if (ip == 0) {
							list.add(A);
							if (md_mode != 1) {
								list.add(B);
								list.add(C);
								list.add(D);
								list.add(E);
							}
							backup.add(A);
							backup.add(B);
							backup.add(C);
							backup.add(D);
							backup.add(E);
						} else if (ip == 1) {
							list.add(B);
							if (md_mode != 1) {
								list.add(A);
								list.add(C);
								list.add(D);
								list.add(E);
							}
							backup.add(B);
							backup.add(A);
							backup.add(C);
							backup.add(D);
							backup.add(E);
						} else if (ip == 2) {
							list.add(C);
							if (md_mode != 1) {
								list.add(D);
								list.add(E);
								list.add(A);
								list.add(B);
							}
							backup.add(C);
							backup.add(D);
							backup.add(E);
							backup.add(A);
							backup.add(B);
						} else if (ip == 3) {
							list.add(D);
							if (md_mode != 1) {
								list.add(E);
								list.add(C);
								list.add(A);
								list.add(B);
							}
							backup.add(D);
							backup.add(E);
							backup.add(C);
							backup.add(A);
							backup.add(B);
						} else {
							list.add(E);
							if (md_mode != 1) {
								list.add(D);
								list.add(B);
								list.add(A);
								list.add(C);
							}
							backup.add(E);
							backup.add(D);
							backup.add(B);
							backup.add(A);
							backup.add(C);
						}
						ArrayList<String> autoUser = new ArrayList<String>();
						// �ƯZ����
						for (int au = 0; au < list.size(); au++) {
							for (int aug = 0; aug < list.get(au).size(); aug++) {
								String sms = list.get(au).get(aug);
								if (addUs(sms, autoUser)) {
									autoUser.add(sms);
									// MainActivity.out("g9/auto.."+autoUser.get(index));
								}
							}
						}
						// backup����
						ArrayList<String> backUser = new ArrayList<String>();
						for (int bu = 0; bu < backup.size(); bu++) {
							for (int bug = 0; bug < backup.get(bu).size(); bug++) {
								String bms = backup.get(bu).get(bug);
								if (addUs(bms, backUser)) {
									backUser.add(bms);
									// MainActivity.out("g9/auto.."+autoUser.get(index));
								}
							}
						}

						int ipp = Integer.parseInt(pp); // �H��
						int imx = Integer.parseInt(mx); // �s�Z�W��
						for (int mp = 0; mp < ipp; mp++) {
							boolean adduser = false;
							ArrayList<String> autoG1 = new ArrayList<String>(); // �Ըɤ@
							ArrayList<String> autoG2 = new ArrayList<String>(); // �ԸɤG
							ArrayList<String> autoG3 = new ArrayList<String>(); // �ԸɤT
							ArrayList<String> autoG4 = new ArrayList<String>(); // �Ըɥ|

							for (int wau = 0; wau < autoUser.size(); wau++) {
								int mmx = NameToMax(autoUser.get(wau));
								if (mmx == 0) {
									mmx = 99;
								}
								// TODO fx
								int mwd = workMonth.get(NameToPath(autoUser.get(wau)));
								if (mwd >= getAverage(ip, 3, 1) || mwd >= mmx) {
									// �[�J�ĤG���q�ԸɦW��
									autoG1.add(autoUser.get(wau));
								} else {
									boolean inside = false;
									boolean overtime = false;
									boolean fatigue = false;

									// ��饼��
									for (int adt = 0; adt < autoDay.size(); adt++) {
										String adts = MainActivity.getLine(autoDay.get(adt), 1, '/');
										if (debug) {
											if (adts.equals(autoUser.get(wau))) {
												inside = true;
											}
										} else {
											if (PathToName(Integer.parseInt(adts)).equals(autoUser.get(wau))) {
												inside = true;
											}
										}
									}

									if (!inside) {
										// �s��W�Z�ˬd
										// umx �ϥΪ̤w�s�Z�W��
										// imx �u�@���w�s�Z�W��
										int umx = workDay.get(NameToPath(autoUser.get(wau)));
										if (umx >= imx) {
											overtime = true;
										}
									}

									if (!inside && !overtime) {
										// �Q��W�Z�ˬd
										int up = yesterday.get(NameToPath(autoUser.get(wau)));
										if (up != 99) {
											if (ip != up) {
												fatigue = true;
											}
										}
									}
									if (!inside && !overtime && !fatigue) {
										// �s��
										adduser = true;
										int wmi = workMonth.get(NameToPath(autoUser.get(wau))) + 1;
										int wdi = workDay.get(NameToPath(autoUser.get(wau))) + 1;
										join.set(NameToPath(autoUser.get(wau)), true); // ���W�Z
										workMonth.set(NameToPath(autoUser.get(wau)), wmi); // ��Z��+1
										workDay.set(NameToPath(autoUser.get(wau)), wdi); // �s��W�Z+1
										yesterday.set(NameToPath(autoUser.get(wau)), ip); // �Q��Z��
										if (debug) {
											autoDay.add("2" + autoUser.get(wau) + '/' + ws.substring(1) + '|'); // ����
										} else {
											autoDay.add(
													"2" + NameToPath(autoUser.get(wau)) + '/' + ws.substring(1) + '|'); // ����
										}
										break;
									}
								}
							}
							if (!adduser) {
								for (int wau = 0; wau < autoG1.size(); wau++) {
									int mxx = NameToMax(autoG1.get(wau));
									if (mxx == 0) {
										mxx = 99;
									}
									// TODO (fx * 2)
									int mwd = workMonth.get(NameToPath(autoG1.get(wau)));
									if (mwd >= getAverage(ip, 3, 2) || mwd >= mxx) {
										// �[�J�ĤT���q�Ը�
										autoG2.add(autoG1.get(wau));
									} else {
										boolean inside = false;
										boolean overtime = false;
										boolean fatigue = false;
										// ��饼��
										for (int adt = 0; adt < autoDay.size(); adt++) {
											String adts = MainActivity.getLine(autoDay.get(adt), 1, '/');
											if (debug) {
												if (adts.equals(autoG1.get(wau))) {
													inside = true;
												}
											} else {
												if (PathToName(Integer.parseInt(adts)).equals(autoG1.get(wau))) {
													inside = true;
												}
											}
										}

										if (!inside) {
											// �s��W�Z�ˬd
											// umx �ϥΪ̤w�s�Z�W��
											// imx �u�@���w�s�Z�W��
											int umx = workDay.get(NameToPath(autoG1.get(wau)));
											if (umx >= imx) {
												overtime = true;
											}
										}

										if (!inside && !overtime) {
											// �Q��W�Z�ˬd
											int up = yesterday.get(NameToPath(autoG1.get(wau)));
											if (up != 99) {
												if (ip != up) {
													fatigue = true;
												}
											}
										}

										if (!inside && !overtime && !fatigue) {// �s��
											adduser = true;
											int wmi = workMonth.get(NameToPath(autoG1.get(wau))) + 1;
											int wdi = workDay.get(NameToPath(autoG1.get(wau))) + 1;
											join.set(NameToPath(autoG1.get(wau)), true); // ���W�Z
											workMonth.set(NameToPath(autoG1.get(wau)), wmi); // ��Z��+1
											workDay.set(NameToPath(autoG1.get(wau)), wdi); // �s��W�Z+1
											yesterday.set(NameToPath(autoG1.get(wau)), ip); // �Q��Z��
											if (debug) {
												autoDay.add("2" + autoG1.get(wau) + '/' + ws.substring(1) + '|'); // ����
											} else {
												autoDay.add("2" + NameToPath(autoG1.get(wau)) + '/' + ws.substring(1)
														+ '|'); // ����
											}
											break;
										}
									}
								}

								if (!adduser) {
									for (int wau = 0; wau < autoG2.size(); wau++) {
										int mmx = NameToMax(autoG2.get(wau));
										if (mmx == 0) {
											mmx = 99;
										}
										// TODO umax
										int mwd = workMonth.get(NameToPath(autoG2.get(wau)));
										if (mwd >= getAverage(ip, 1, 1) || mwd >= mmx) {
											autoG3.add(autoG2.get(wau));
										} else {
											boolean inside = false;
											boolean overtime = false;
											boolean fatigue = false;

											// ��饼��
											for (int adt = 0; adt < autoDay.size(); adt++) {
												String adts = MainActivity.getLine(autoDay.get(adt), 1, '/');
												if (debug) {
													if (adts.equals(autoG2.get(wau))) {
														inside = true;
													}
												} else {
													if (PathToName(Integer.parseInt(adts)).equals(autoG2.get(wau))) {
														inside = true;
													}
												}
											}

											if (!inside) {
												// �s��W�Z�ˬd
												// umx �ϥΪ̤w�s�Z�W��
												// imx �u�@���w�s�Z�W��
												int umx = workDay.get(NameToPath(autoG2.get(wau)));
												if (umx >= imx) {
													overtime = true;
												}
											}

											if (!inside && !overtime) {
												// �Q��W�Z�ˬd
												int up = yesterday.get(NameToPath(autoG2.get(wau)));
												if (up != 99) {
													if (ip != up) {
														fatigue = true;
													}
												}
											}
											if (!inside && !overtime && !fatigue) {// �s��
												adduser = true;
												int wmi = workMonth.get(NameToPath(autoG2.get(wau))) + 1;
												int wdi = workDay.get(NameToPath(autoG2.get(wau))) + 1;
												join.set(NameToPath(autoG2.get(wau)), true); // ���W�Z
												workMonth.set(NameToPath(autoG2.get(wau)), wmi); // ��Z��+1
												workDay.set(NameToPath(autoG2.get(wau)), wdi); // �s��W�Z+1
												yesterday.set(NameToPath(autoG2.get(wau)), ip); // �Q��Z��
												if (debug) {
													autoDay.add("2" + autoG2.get(wau) + '/' + ws.substring(1) + '|'); // ����
												} else {
													autoDay.add("2" + NameToPath(autoG2.get(wau)) + '/'
															+ ws.substring(1) + '|'); // ����
												}
												break;
											}
										}
									}
								}
								if (!adduser) {
									for (int eau = 0; eau < autoG3.size(); eau++) {
										int mxx = NameToMax(autoG3.get(eau));
										if (mxx == 0) {
											mxx = 99;
										}
										// TODO (umax + 1)
										int mwd = workMonth.get(NameToPath(autoG3.get(eau))) - 1;
										if (mwd >= getAverage(ip, 1, 1) || mwd >= mxx) {
											autoG4.add(autoG3.get(eau));
										} else {
											boolean inside = false;
											boolean overtime = false;
											boolean fatigue = false;

											// ��饼��
											for (int adt = 0; adt < autoDay.size(); adt++) {
												String adts = MainActivity.getLine(autoDay.get(adt), 1, '/');
												if (debug) {
													if (adts.equals(autoG3.get(eau))) {
														inside = true;
													}
												} else {
													if (PathToName(Integer.parseInt(adts)).equals(autoG3.get(eau))) {
														inside = true;
													}
												}
											}

											if (!inside) {
												// �s��W�Z�ˬd
												// umx �ϥΪ̤w�s�Z�W��
												// imx �u�@���w�s�Z�W��
												int umx = workDay.get(NameToPath(autoG3.get(eau)));
												if (umx >= imx) {
													overtime = true;
												}
											}

											if (!inside && !overtime) {
												// �Q��W�Z�ˬd
												int up = yesterday.get(NameToPath(autoG3.get(eau)));
												if (up != 99) {
													if (ip == 0) {
														// �կZ
														if (up == 2 || up == 3 || up == 4) {
															// ���W�p�],�]�[,�j�]
															fatigue = true;
														}
													} else if (ip == 1) {
														// ���[
														if (up == 2 || up == 3) {
															// ���W�p�],�]�[
															fatigue = true;
														}
													} else if (ip == 2) {
														// �p�]
														if (up == 3 || up == 4) {
															// ���W�]�[,�j�]
															fatigue = true;
														}
													} else if (ip == 3) {
														// �]�[
														if (up == 0 || up == 1) {
															// ���W�կZ,���[
															fatigue = true;
														}
													} else {
														// �j�]
														if (up == 0 || up == 1) {
															// ���W�կZ,���[
															fatigue = true;
														}
													}
												}
											}

											if (!inside && !overtime && !fatigue) {
												adduser = true;
												int wmi = workMonth.get(NameToPath(autoG3.get(eau))) + 1;
												int wdi = workDay.get(NameToPath(autoG3.get(eau))) + 1;
												join.set(NameToPath(autoG3.get(eau)), true); // ���W�Z
												workMonth.set(NameToPath(autoG3.get(eau)), wmi); // ��Z��+1
												workDay.set(NameToPath(autoG3.get(eau)), wdi); // �s��W�Z+1
												yesterday.set(NameToPath(autoG3.get(eau)), ip); // �Q��Z��
												if (debug) {
													autoDay.add("2" + autoG3.get(eau) + '/' + ws.substring(1) + '|'); // ����
												} else {
													autoDay.add("2" + NameToPath(autoG3.get(eau)) + '/'
															+ ws.substring(1) + '|'); // ����
												}
												break;
											}
										}
									}
								}
								if (!adduser) {
									if (spp_mode == 0) {
										ArrayList<String> autoG5 = new ArrayList<String>(); // �Ըɤ�
										if (md_mode != 1) {
											for (int ato = 0; ato < autoG4.size(); ato++) {
												autoG5.add(autoG4.get(ato));
											}
										} else {
											for (int bto = 0; bto < backUser.size(); bto++) {
												autoG5.add(backUser.get(bto));
											}
										}
										while (autoG5.size() != 0) {
											int ng = new Random().nextInt(autoG5.size());
											int x = NameToMax(autoG5.get(ng));
											if (x == 0) {
												x = 99;
											}
											int mwd = workMonth.get(NameToPath(autoG5.get(ng))) - 2;
											// �L�k�ƯZ�B�z
											if (mwd >= getAverage(ip, 1, 1) || mwd >= x) {
												autoG5.remove(ng);
											} else {
												boolean inside = false;
												boolean overtime = false;
												boolean fatigue = false;

												// ��饼��
												for (int adt = 0; adt < autoDay.size(); adt++) {
													String adts = MainActivity.getLine(autoDay.get(adt), 1, '/');
													if (debug) {
														if (adts.equals(autoG5.get(ng))) {
															inside = true;
														}
													} else {
														if (PathToName(Integer.parseInt(adts)).equals(autoG5.get(ng))) {
															inside = true;
														}
													}
												}
												// �s��W�Z�ˬd
												if (!inside) {
													// umx �ϥΪ̤w�s�Z�W��
													// imx �u�@���w�s�Z�W��
													int umx = workDay.get(NameToPath(autoG5.get(ng)));
													if (umx >= imx) {
														overtime = true;
													}
												}
												// �Q��W�Z�ˬd
												if (!inside && !overtime) {
													int up = yesterday.get(NameToPath(autoG5.get(ng)));
													if (up != 99) {
														if (ip == 0) {
															// �կZ
															if (up == 2 || up == 3 || up == 4) {
																// ���W�p�],�]�[,�j�]
																fatigue = true;
															}
														} else if (ip == 1) {
															// ���[
															if (up == 2 || up == 3) {
																// ���W�p�],�]�[
																fatigue = true;
															}
														} else if (ip == 2) {
															// �p�]
															if (up == 3 || up == 4) {
																// ���W�]�[,�j�]
																fatigue = true;
															}
														} else if (ip == 3) {
															// �]�[
															if (up == 0 || up == 1) {
																// ���W�կZ,���[
																fatigue = true;
															}
														} else {
															// �j�]
															if (up == 0 || up == 1) {
																// ���W�կZ,���[
																fatigue = true;
															}
														}
													}
												}
												if (!inside && !overtime && !fatigue) {
													adduser = true;
													int wmi = workMonth.get(NameToPath(autoG5.get(ng))) + 1;
													int wdi = workDay.get(NameToPath(autoG5.get(ng))) + 1;
													join.set(NameToPath(autoG5.get(ng)), true); // ���W�Z
													workMonth.set(NameToPath(autoG5.get(ng)), wmi); // ��Z��+1
													workDay.set(NameToPath(autoG5.get(ng)), wdi); // �s��W�Z+1
													yesterday.set(NameToPath(autoG5.get(ng)), ip); // �Q��Z��
													if (debug) {
														autoDay.add("2" + autoG5.get(ng) + '/' + ws.substring(1) + '|'); // ����
													} else {
														autoDay.add("2" + NameToPath(autoG5.get(ng)) + '/'
																+ ws.substring(1) + '|'); // ����
													}
													break;
												} else {
													autoG5.remove(ng);
												}
											}
										}
									}
								}
								if (!adduser) {
									autoDay.add("299/" + ws.substring(1) + '|');
									MainActivity.RedPoint
											.add(new GetPoint(MainActivity.Years, (MainActivity.Months + 1), j));
								}
							}
						}
					}
				} // Work.size()
			} else {
				if (Work.size() != 0 && User.size() == 0) {
					// MainActivity.out("g9/error.. " + j + " �Z����~!");
					for (int w = 0; w < Work.size(); w++) {
						String ws = Work.get(w), na, pp;
						String wp = MainActivity.getLine(ws, 1, '/'); // work.get(p);
						int xwp = Integer.parseInt(wp);
						if (xwp < MainActivity.Worklist.size()) {
							String wss = MainActivity.Worklist.get(xwp); // work.get(p).toString;
							// �կZ�оǦ^�E1|1|08|11|
							int r = 0;
							na = MainActivity.getLine(wss, r, '|');
							r += na.length() + 3;
							pp = MainActivity.getLine(wss, r, '|');
							int ipp = Integer.parseInt(pp); // �H��
							for (int mp = 0; mp < ipp; mp++) {
								autoDay.add("299/" + ws.substring(1) + '|');
								MainActivity.RedPoint
										.add(new GetPoint(MainActivity.Years, (MainActivity.Months + 1), j));
							}
						}
					}
				}
			}
			// ���b�Z��
			for (int jvls = 0; jvls < P.size(); jvls++) {
				String ppi = P.get(jvls);
				if (ppi.length() != 0) {
					I.add(MainActivity.getLine(
							MainActivity.Userlist.get(Integer.parseInt(MainActivity.getLine(P.get(jvls), 1, '/'))), 0,
							'|'));
				}
			}
			for (int cvls = 0; cvls < join.size(); cvls++) {
				String csls = MainActivity.getLine(MainActivity.Userlist.get(cvls), 0, '|');
				if (!NameToName(csls, I)) {
					F.add(csls);
				}
			}
			// ����
			String usfu = "";
			for (int us = 0; us < F.size(); us++) {
				if (debug) {
					usfu += "4" + F.get(us) + '|';
				} else {
					usfu += "4" + NameToPath(F.get(us)) + '|';
				}
			}
			// ��
			String unji = "";
			for (int ji = 0; ji < join.size(); ji++) {
				if (!join.get(ji)) {
					workDay.set(ji, 0);
					yesterday.set(ji, 99);
					String jina = MainActivity.getLine(MainActivity.Userlist.get(ji), 0, '|');
					if (!debug) {
						jina = NameToPath(jina) + "";
					}
					if (!NameToName(jina, F)) {
						if (debug) {
							unji += "3" + PathToName(ji) + '|';
						} else {
							unji += "3" + NameToPath(PathToName(ji)) + '|';
						}
					}
				}
			}
			String sadm = "";
			for (int adm = 0; adm < autoDay.size(); adm++) {
				sadm += autoDay.get(adm);
			}
			autoMonth.add(sadm + unji + usfu);
		}

		MainActivity.Datelist.set(0, (MainActivity.Datelist.get(0) + "0"));
		for (int amm = 0; amm < autoMonth.size(); amm++) {
			MainActivity.Datelist.set((amm + 1), (MainActivity.Datelist.get(amm + 1) + autoMonth.get(amm)));
		}
		MoreActivity.m_up = false;
		MainActivity.updateDay(this);
		MainActivity.toast(this, "�w����.");

		// new Timer(true).schedule(new TimerTask() {
		// public void run() {
		// }
		// }, 3000);
		finish();

	}

	@SuppressWarnings("unused")
	private String UsertoName(String na) {
		String una = MainActivity.getLine(na, 1, '/');
		String mus = MainActivity.Userlist.get(Integer.parseInt(una));
		String mna = MainActivity.getLine(mus, 0, '|');
		return mna;
	}

	private boolean NameToName(String na, ArrayList<String> F) {
		boolean rev = false;
		for (int rf = 0; rf < F.size(); rf++) {
			if (F.get(rf).equals(na)) {
				rev = true;
			}
		}
		return rev;
	}

	private String PathToName(int name) {
		if (name < MainActivity.Userlist.size()) {
			return MainActivity.getLine(MainActivity.Userlist.get(name), 0, '|');
		} else {
			return "99";
		}
	}

	private int RandomPath(String name) {
		for (int i = 0; i < J.size(); i++) {
			String na = J.get(i);
			if (na.equals(name)) {
				return i;
			}
		}
		return 0;
	}

	private int RegularPath(int i, int j, int m) {
		int k = i - j;
		if (k < 0) {
			return m + k;
		} else {
			return k;
		}
	}

	private int NameToMax(String name) {
		for (int i = 0; i < MainActivity.Userlist.size(); i++) {
			int r = 0;
			String s = MainActivity.Userlist.get(i);
			String na = MainActivity.getLine(s, r, '|');
			r += na.length() + 1;
			String pw = MainActivity.getLine(s, r, '|');
			r += pw.length() + 1;
			String ot = MainActivity.getLine(s, r, '|');
			r += ot.length() + 1;
			int mx = Integer.parseInt(MainActivity.getLine(s, r, '|'));
			if (na.equals(name)) {
				return mx;
			}
		}
		return 0;
	}

	private int NameToPath(String name) {
		for (int i = 0; i < MainActivity.Userlist.size(); i++) {
			String s = MainActivity.Userlist.get(i);
			String na = MainActivity.getLine(s, 0, '|');
			if (na.equals(name)) {
				return i;
			}
		}
		return 99;
	}

	private boolean addUs(String name, ArrayList<String> aug) {
		for (int i = 0; i < aug.size(); i++) {
			if (name.equals(aug.get(i))) {
				return false;
			}
		}
		return true;
	}

	private int getInteger(EditText edt) {
		int i = 1;
		String s = edt.getText().toString();
		if (!("".equals(s) || "0".equals(s))) {
			i = Integer.parseInt(s);
		}
		return i;
	}

	private int getAverage(int type, int rm, int rx) {
		int i = 1;
		switch (type) {
		case 0:
			i = rule_0;
			break;
		case 1:
			i = rule_1;
			break;
		case 2:
			i = rule_2;
			break;
		case 3:
			i = rule_3;
			break;
		case 4:
			i = rule_4;
			break;
		default:
			break;
		}
		return ((i / rm) * rx);
	}

	private void load() {
		// �կZ�оǦ^�E1|1|08|11|0|
		ArrayList<String> K = new ArrayList<String>(); // �üƼȦs
		J.clear();
		int w = 0;
		ArrayList<String> ustmp = new ArrayList<String>();
		for (int i = 0; i < MainActivity.Datelist.size(); i++) {
			String mmsg = MainActivity.Datelist.get(i), tmp;
			if (i == 0) {
				tmp = mmsg.substring(4);
				if (tmp.length() > 0) {
					// String d = tmp.substring(0, 2);
					// day = Integer.parseInt(d);
					int r = 2;
					String us = MainActivity.getLine(tmp, r, '/');
					r += us.length() + 1;
					String m = MainActivity.getLine(tmp, r, '/');
					// �¬���
					// sm = Integer.parseInt(m)
					max.setText(m + "");
					umax = Integer.parseInt(m);
				} else {
					MainActivity.toast(this, "�ާ@���~.");
				}
			} else {
				int run = 0;
				char key = '|';
				// msg += 0 + "" + i + "/|"; �կZ,����,�p�],�]�[,�j�]
				// msg += 1 + "" + i + "/11111|;"
				while (mmsg.indexOf(key, run) != -1) {
					tmp = MainActivity.getLine(mmsg, run, key);
					run += tmp.length() + 1;
					if (tmp.substring(0, 1).equals("0")) {
						String p = MainActivity.getLine(tmp, 1, '/');
						int awp = Integer.parseInt(p);
						if (awp < MainActivity.Worklist.size()) {
							String s = MainActivity.Worklist.get(awp);
							int r = 0;
							String sna = MainActivity.getLine(s, r, '|');
							r += sna.length() + 1;
							String stp = MainActivity.getLine(s, r, '|');
							r += 2;
							String spp = MainActivity.getLine(s, r, '|');
							// MainActivity.out("g16/" + s);
							// String sp = MainActivity.getLine(s,
							// MainActivity.getLine(s, 0, '|').length() + 1,
							// '|');
							String c = tmp.substring(2 + p.length());
							if (c != null) {
								if (c.length() != 0) {
									ArrayList<String> list = new ArrayList<String>();
									int cr = 0;
									char ck = '/';
									while (c.indexOf(ck, cr) != -1) {
										String ctmp = MainActivity.getLine(c, cr, ck);
										list.add(ctmp); // A||
										cr += ctmp.length() + 1;
									}
									for (int l = 0; l < list.size(); l++) {
										String a = list.get(l).substring(0, 1);
										String b = list.get(l).substring(1);
										// m += "1" + i + "/";
										if (a.equals("1")) {
											spp = b;
										}
									}
								}
							}
							w += Integer.parseInt(spp);
							// TODO rule
							if ("0".equals(stp)) {
								rule_0 += Integer.parseInt(spp);
								wwe[0] = true;
							}
							if ("1".equals(stp)) {
								rule_1 += Integer.parseInt(spp);
								wwe[1] = true;
							}
							if ("2".equals(stp)) {
								rule_2 += Integer.parseInt(spp);
								wwe[2] = true;
							}
							if ("3".equals(stp)) {
								rule_3 += Integer.parseInt(spp);
								wwe[3] = true;
							}
							if ("4".equals(stp)) {
								rule_4 += Integer.parseInt(spp);
								wwe[4] = true;
							}
						}
					}
					if (tmp.substring(0, 1).equals("1")) {
						String up = MainActivity.getLine(tmp, 1, '/');
						int aup = Integer.parseInt(up);
						if (aup < MainActivity.Userlist.size()) {
							String nab = MainActivity.getLine(MainActivity.Userlist.get(aup), 0, '|');
							boolean ad = true;
							for (int p = 0; p < ustmp.size(); p++) {
								if (ustmp.get(p).equals(up)) {
									ad = false;
									break;
								}
							}
							if (ad) {
								ustmp.add(up);
								K.add(nab);
							}
						}
					}
				}
			}
		}
		while (K.size() != 0) {
			int ks = new Random().nextInt(K.size());
			J.add(K.get(ks));
			K.remove(ks);
		}
		user.setText(ustmp.size() + "");
		Integer.parseInt(MainActivity.getSQLdate().substring(2, 4));
		day.setText(DateUtils.getMonthDays(MainActivity.Years, MainActivity.Months) + "");
		work.setText(w + "");
		// umax = ((w / su) + 1);
		// max.setText(umax + "");
		mdm.setOnItemSelectedListener(this);
		ArrayAdapter<String> mdm_adapter_0 = new ArrayAdapter<String>(this, R.layout.style_spinner,
				new String[] { "���Z", "�T�w�Z" });
		mdm_adapter_0.setDropDownViewResource(R.layout.style_spinner);
		mdm.setAdapter(mdm_adapter_0);
		mdm.setSelection(0);
		mdr.setOnItemSelectedListener(this);
		ArrayAdapter<String> mdr_adapter_0 = new ArrayAdapter<String>(this, R.layout.style_spinner,
				new String[] { "�ç�", "����" });
		mdr_adapter_0.setDropDownViewResource(R.layout.style_spinner);
		mdr.setAdapter(mdr_adapter_0);
		mdr.setSelection(1);
		ac.setOnItemSelectedListener(this);
		ArrayList<String> aclist = new ArrayList<String>();
		for (int i = 0; i < MainActivity.Userlist.size(); i++) {
			aclist.add(MainActivity.getLine(MainActivity.Userlist.get(i), 0, '|'));
		}
		ArrayAdapter<String> ac_adapter_0 = new ArrayAdapter<String>(this, R.layout.style_spinner, aclist);
		ac_adapter_0.setDropDownViewResource(R.layout.style_spinner);
		ac.setAdapter(ac_adapter_0);
		ac.setSelection(0);
		spp.setOnItemSelectedListener(this);
		ArrayAdapter<String> spp_adapter_0 = new ArrayAdapter<String>(this, R.layout.style_spinner,
				new String[] { "�۰ʱư�", "��ʱư�" });
		spp_adapter_0.setDropDownViewResource(R.layout.style_spinner);
		spp.setAdapter(spp_adapter_0);
		spp.setSelection(1);
		yes.setOnClickListener(this);
		no.setOnClickListener(this);
	}

	@SuppressLint("InflateParams")
	private void setListViewAdapter(int f, ArrayList<View> view, ArrayList<String> list, Context con) {
		final int i = f;
		View vi = LayoutInflater.from(con).inflate(R.layout.style_textview3, null);
		TextView name = (TextView) vi.findViewById(R.id.t3_name);
		EditText equal = (EditText) vi.findViewById(R.id.t3_equal);
		if (i < list.size()) {
			name.setText(MainActivity.getLine(list.get(i), 0, '|'));
			ed.add(equal);
		} else {
			equal.setVisibility(View.INVISIBLE);
			vi.setEnabled(false);
		}
		view.add(vi);
	}

	private void setView(Context con) {
		UserworkView.clear();
		for (int i = 0; i < MainActivity.Userlist.size(); i++) {
			setListViewAdapter(i, UserworkView, MainActivity.Userlist, con);
		}
		list.setAdapter(new MyListAdapter(UserworkView));
	}

	public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
		switch (parent.getId()) {
		case R.id.auto_spp:
			spp_mode = position;
			break;
		case R.id.auto_ac:
			ac_mode = position;
			break;
		case R.id.auto_rule:
			md_rule = position;
			if (position == 0) {
				tac.setVisibility(View.GONE);
			} else {
				tac.setVisibility(View.VISIBLE);
			}
			break;
		case R.id.auto_mode:
			md_mode = position;
			if (position == 0) {
				trm.setVisibility(View.VISIBLE);
				tra.setVisibility(View.GONE);
				trb.setVisibility(View.GONE);
				trc.setVisibility(View.GONE);
				trd.setVisibility(View.GONE);
				tre.setVisibility(View.GONE);
			} else {
				trm.setVisibility(View.GONE);
				if (wwe[0]) {
					tra.setVisibility(View.VISIBLE);
				}
				if (wwe[1]) {
					trb.setVisibility(View.VISIBLE);
				}
				if (wwe[2]) {
					trc.setVisibility(View.VISIBLE);
				}
				if (wwe[3]) {
					trd.setVisibility(View.VISIBLE);
				}
				if (wwe[4]) {
					tre.setVisibility(View.VISIBLE);
				}
			}
			break;
		default:
			break;
		}
	}

	public void onNothingSelected(AdapterView<?> parent) {

	}
}
