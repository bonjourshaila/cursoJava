PGDMP     
                     y            curso    13.1    13.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16396    curso    DATABASE     b   CREATE DATABASE curso WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Mexico.1252';
    DROP DATABASE curso;
                postgres    false                        2615    16397    curso    SCHEMA        CREATE SCHEMA curso;
    DROP SCHEMA curso;
                postgres    false            �            1259    16398    c_tipo_producto    TABLE     m  CREATE TABLE curso.c_tipo_producto (
    id_tipo_producto integer NOT NULL,
    tipo_producto character varying NOT NULL,
    usuario_alta bigint NOT NULL,
    usuario_modificacion bigint NOT NULL,
    fecha_alta timestamp without time zone NOT NULL,
    fecha_modificacion timestamp without time zone NOT NULL,
    registro_activo boolean DEFAULT true NOT NULL
);
 "   DROP TABLE curso.c_tipo_producto;
       curso         heap    postgres    false    6            �            1259    16405    sec_almacen    SEQUENCE     s   CREATE SEQUENCE curso.sec_almacen
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE curso.sec_almacen;
       curso          postgres    false    6            �            1259    16407 	   m_almacen    TABLE     �  CREATE TABLE curso.m_almacen (
    id_almacen integer DEFAULT nextval('curso.sec_almacen'::regclass) NOT NULL,
    nombre_almacen character varying NOT NULL,
    usuario_alta bigint NOT NULL,
    usuario_modificacion bigint NOT NULL,
    fecha_alta timestamp without time zone NOT NULL,
    fecha_modificacion timestamp without time zone NOT NULL,
    registro_activo boolean DEFAULT true NOT NULL
);
    DROP TABLE curso.m_almacen;
       curso         heap    postgres    false    202    6            �            1259    16415    sec_producto    SEQUENCE     t   CREATE SEQUENCE curso.sec_producto
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE curso.sec_producto;
       curso          postgres    false    6            �            1259    16417 
   m_producto    TABLE     �  CREATE TABLE curso.m_producto (
    id_producto bigint DEFAULT nextval('curso.sec_producto'::regclass) NOT NULL,
    nombre character varying NOT NULL,
    usuario_alta bigint NOT NULL,
    usuario_modificacion bigint NOT NULL,
    fecha_alta timestamp without time zone NOT NULL,
    fecha_modificacion timestamp without time zone NOT NULL,
    registro_activo boolean DEFAULT true NOT NULL,
    id_tipo_producto integer NOT NULL
);
    DROP TABLE curso.m_producto;
       curso         heap    postgres    false    204    6            �            1259    16425    sec_producto_almacen    SEQUENCE     �   CREATE SEQUENCE curso.sec_producto_almacen
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 454545115451
    CACHE 1;
 *   DROP SEQUENCE curso.sec_producto_almacen;
       curso          postgres    false    6            �            1259    16427    r_producto_almacen    TABLE     �  CREATE TABLE curso.r_producto_almacen (
    id_producto_almacen bigint DEFAULT nextval('curso.sec_producto_almacen'::regclass) NOT NULL,
    id_producto bigint NOT NULL,
    id_almacen integer NOT NULL,
    usurio_alta bigint NOT NULL,
    usuario_modificacion bigint NOT NULL,
    fecha_alta timestamp without time zone NOT NULL,
    fecha_modificacion timestamp without time zone NOT NULL,
    registro_activo boolean DEFAULT true NOT NULL
);
 %   DROP TABLE curso.r_producto_almacen;
       curso         heap    postgres    false    206    6            �          0    16398    c_tipo_producto 
   TABLE DATA           �   COPY curso.c_tipo_producto (id_tipo_producto, tipo_producto, usuario_alta, usuario_modificacion, fecha_alta, fecha_modificacion, registro_activo) FROM stdin;
    curso          postgres    false    201   "       �          0    16407 	   m_almacen 
   TABLE DATA           �   COPY curso.m_almacen (id_almacen, nombre_almacen, usuario_alta, usuario_modificacion, fecha_alta, fecha_modificacion, registro_activo) FROM stdin;
    curso          postgres    false    203   m"       �          0    16417 
   m_producto 
   TABLE DATA           �   COPY curso.m_producto (id_producto, nombre, usuario_alta, usuario_modificacion, fecha_alta, fecha_modificacion, registro_activo, id_tipo_producto) FROM stdin;
    curso          postgres    false    205   �"       �          0    16427    r_producto_almacen 
   TABLE DATA           �   COPY curso.r_producto_almacen (id_producto_almacen, id_producto, id_almacen, usurio_alta, usuario_modificacion, fecha_alta, fecha_modificacion, registro_activo) FROM stdin;
    curso          postgres    false    207   �$       �           0    0    sec_almacen    SEQUENCE SET     9   SELECT pg_catalog.setval('curso.sec_almacen', 1, false);
          curso          postgres    false    202            �           0    0    sec_producto    SEQUENCE SET     :   SELECT pg_catalog.setval('curso.sec_producto', 18, true);
          curso          postgres    false    204            �           0    0    sec_producto_almacen    SEQUENCE SET     B   SELECT pg_catalog.setval('curso.sec_producto_almacen', 1, false);
          curso          postgres    false    206            >           2606    16433 $   c_tipo_producto c_tipo_producto_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY curso.c_tipo_producto
    ADD CONSTRAINT c_tipo_producto_pkey PRIMARY KEY (id_tipo_producto);
 M   ALTER TABLE ONLY curso.c_tipo_producto DROP CONSTRAINT c_tipo_producto_pkey;
       curso            postgres    false    201            @           2606    16435    m_almacen m_almacen_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY curso.m_almacen
    ADD CONSTRAINT m_almacen_pkey PRIMARY KEY (id_almacen);
 A   ALTER TABLE ONLY curso.m_almacen DROP CONSTRAINT m_almacen_pkey;
       curso            postgres    false    203            B           2606    16437    m_producto m_producto_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY curso.m_producto
    ADD CONSTRAINT m_producto_pkey PRIMARY KEY (id_producto);
 C   ALTER TABLE ONLY curso.m_producto DROP CONSTRAINT m_producto_pkey;
       curso            postgres    false    205            D           2606    16439 *   r_producto_almacen r_producto_almacen_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY curso.r_producto_almacen
    ADD CONSTRAINT r_producto_almacen_pkey PRIMARY KEY (id_producto_almacen);
 S   ALTER TABLE ONLY curso.r_producto_almacen DROP CONSTRAINT r_producto_almacen_pkey;
       curso            postgres    false    207            E           2606    16440    m_producto m_producto_fk    FK CONSTRAINT     �   ALTER TABLE ONLY curso.m_producto
    ADD CONSTRAINT m_producto_fk FOREIGN KEY (id_tipo_producto) REFERENCES curso.c_tipo_producto(id_tipo_producto);
 A   ALTER TABLE ONLY curso.m_producto DROP CONSTRAINT m_producto_fk;
       curso          postgres    false    2878    201    205            F           2606    16445 1   r_producto_almacen r_producto_almacen__almacen_fk    FK CONSTRAINT     �   ALTER TABLE ONLY curso.r_producto_almacen
    ADD CONSTRAINT r_producto_almacen__almacen_fk FOREIGN KEY (id_almacen) REFERENCES curso.m_almacen(id_almacen);
 Z   ALTER TABLE ONLY curso.r_producto_almacen DROP CONSTRAINT r_producto_almacen__almacen_fk;
       curso          postgres    false    2880    203    207            G           2606    16450 (   r_producto_almacen r_producto_almacen_fk    FK CONSTRAINT     �   ALTER TABLE ONLY curso.r_producto_almacen
    ADD CONSTRAINT r_producto_almacen_fk FOREIGN KEY (id_producto) REFERENCES curso.m_producto(id_producto);
 Q   ALTER TABLE ONLY curso.r_producto_almacen DROP CONSTRAINT r_producto_almacen_fk;
       curso          postgres    false    205    2882    207            �   Y   x�3�tJM�LI,�4B##]C#]Cc#c+s+S#�b%\���I�EE�%���4�t+*-!�BΰԢ��"�5�r:�$摬/F��� ��:�      �      x������ � �      �   �  x�}�݊1���O�/0E�'�$wˀ�� �w�ıq[��a�]p�[_��Ev�;t���ǩsN���s�why��sA-!�s�6�v�n;�j���u�(��$��hv�at�N�i?<�{�%`�Q��W&�$q���Ӹ�	Er���	��υ4S
�@�������F{��C-F2`TD4�t�ތ�K �B|
ɜ|
�ռ�dBYϠ�w����}�뗩]�[1CP�@- E���vwC[���7H䞸x{��
���xNMMԴ���i�?��"��i�5�s���A�(��f���`+�ˎ���D�����INz���?�N+��EQd���s6/��m=<�C#�,�d��^cb6�����;�b��M��D��ȯ��Jf�"(��+ݾn4.�6h��سN�c�� ���sL��&VJ����]=֟�y�\�_kb�k��9�����,���UnG���,��?A�u ���      �      x������ � �     