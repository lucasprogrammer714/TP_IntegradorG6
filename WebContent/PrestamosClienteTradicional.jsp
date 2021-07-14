<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String user="";
if(request.getAttribute("Usuario")!=null)
user=request.getAttribute("Usuario").toString();
%>

<%
session.setAttribute("User", user);
 %>
 
 VALOR Session: <%= session.getAttribute("User") %>


<h1>bienvenido/a</h1>
<!--  ingresar aqui despues el nombre del administrador -->
<p>solicite aqui su prestamo y aguarde su aprobacion o declinacion</p>
<form method="post" action="ServletPrestamos">  <!-- aun no cree este servlet pero es un ejemplo de carga -->
	<table>
		<tr>
			<td>monto solicitado</td>
			<td><input type="text" name="txtMonto"></td>
		</tr>
		<tr>
			<td>cantidad de cuotas</td>
			<td><select name="Cuotas"> 
					<option>3</option><option>4</option><option>5</option>
					<option>6</option><option>7</option><option>8</option>
					<option>9</option><option>10</option><option>11</option>
					<option>12</option><option>13</option><option>14</option>
					<option>15</option><option>16</option><option>17</option>
					<option>18</option><option>19</option><option>20</option>
					<option>21</option><option>22</option><option>23</option>
					<option>24</option><option>25</option><option>26</option>
					<option>27</option><option>28</option><option>29</option>
					<option>30</option><option>31</option><option>32</option>
					<option>33</option><option>34</option><option>35</option>
					<option>36</option><option>37</option><option>38</option>
					<option>39</option><option>40</option><option>41</option>
					<option>42</option><option>43</option><option>44</option>
					<option>45</option><option>46</option><option>47</option><option>48</option>
					<option>49</option><option>50</option><option>51</option><option>52</option>
					<option>53</option><option>54</option><option>55</option><option>56</option>
				<option>57</option><option>58</option><option>59</option><option>60</option>
					<option>61</option><option>62</option><option>63</option><option>64</option>
					<option>65</option><option>66</option><option>67</option><option>68</option>
					<option>69</option><option>70</option><option>71</option><option>72</option>
					
				</select></td>
		</tr>
		<tr>
			<td>tipo de cuenta a depositar</td>
			<td><select name="TipoCuenta"> 
					<option>cuenta corriente</option>
					<option>Cuenta ahorro</option>
				</select>  </td>
				
		</tr>	
		<tr>  <td>tipo de prestamo
				</td> <td>Tradicional</td> </tr>
	</table>
<input type="submit" name="btnEnviar" value="Solicitar Prestamo">
</form>
<a href="UsuarioCliente">volver atras</a>
</body>
</html>